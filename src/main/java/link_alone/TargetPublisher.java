package link_alone;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import zb.dcts.Dcts;
import zb.dcts.aeronaval.Aeronaval;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Random;

/**
 * @author 林跃
 * @file TargetPublisher.java
 * @comment 该类负责向 ZeroMQ 总线发布装备目标数据
 * @date 2025/7/4
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class TargetPublisher {
    private static final int TARGET_COUNT = 1;
    private static final Random RAND = new Random();

    public static void main(String[] args) throws InterruptedException, IOException {
        // 创建 ZeroMQ 上下文
        ZMQ.Context context = ZMQ.context(1);
        // 创建一个发布者套接字
        ZMQ.Socket publisher = context.socket(SocketType.PUB);
        // 绑定到 TCP 地址
        publisher.bind("tcp://*:5555");

        while (true) {
            // 发布目标数据
            for (int i = 0; i < TARGET_COUNT; i++) {
                // 构建随机目标数据
                Aeronaval.Target target = buildRandomTarget(i + 1);
                System.out.println("Target:" + target);
                // 发送目标数据

                ByteArrayOutputStream out = new ByteArrayOutputStream();
                target.writeDelimitedTo(out);
                byte[] bytes = out.toByteArray();
                publisher.sendMore("Target");
                publisher.send(bytes);
                // 打印日志
                System.out.println("[Publisher] Sent Target #" + target.getId());
            }
            Thread.sleep(1000); // 每3秒发布一次目标
        }
    }

    // 构建随机目标数据
    private static Aeronaval.Target buildRandomTarget(int i) throws InterruptedException {
        // 使用当前时间戳
        Instant now = Instant.now();
        Thread.sleep(1000);
        return Aeronaval.Target.newBuilder()
                .setTime(toTimestamp(now))
                .setId(i) // 目标ID从1到3
                .setName("Target-" + RAND.nextInt(3))
                .setCamp(randomCamp())
                .setAirSpace(randomAirSpace())
                .setEquType(randomEquType())
                .setPosition(randomPosition())
                .setPosture(randomPosture())
                .setVelocity(randomVelocity())
                .build();
    }

    // 生成消息类型的Timestamp
    private static Dcts.Timestamp toTimestamp(Instant t) {
        // 将 Instant 转换为 Dcts.Timestamp
        return Dcts.Timestamp.newBuilder()
                .setSeconds((int) t.getEpochSecond())
                .setNanos(t.getNano())
                .build();
    }

    // 随机生成阵营
    private static Aeronaval.Camp randomCamp() {
        // 随机选择一个阵营
        Aeronaval.Camp[] types = Aeronaval.Camp.values();
        return types[RAND.nextInt(types.length - 1)];
    }

    // 随机生成空域类型
    private static Aeronaval.AirSpace randomAirSpace() {
        // 随机选择一个空域类型
        Aeronaval.AirSpace[] types = Aeronaval.AirSpace.values();
        return types[RAND.nextInt(types.length - 1)];
    }

    // 随机生成装备类型
    private static Aeronaval.EquType randomEquType() {
        // 随机选择一个装备类型
        Aeronaval.EquType[] types = Aeronaval.EquType.values();
        return types[RAND.nextInt(types.length - 1)];
    }

    // 随机生成位置
    private static Dcts.Position randomPosition() {
        // 随机生成一个位置
        double lon = 115 + RAND.nextDouble() * 2;  // 115~117
        double lat = 39 + RAND.nextDouble() * 2;   // 39~41
        double alt = 500 + RAND.nextDouble() * 1500;
        return Dcts.Position.newBuilder()
                .setLongitude(lon)
                .setLatitude(lat)
                .setAltitude(alt)
                .build();
    }

    // 随机生成姿态
    private static Dcts.Posture randomPosture() {
        // 随机生成一个姿态
        return Dcts.Posture.newBuilder()
                .setYaw(RAND.nextInt(360))
                .setPitch(RAND.nextInt(90) - 45)
                .setRoll(RAND.nextInt(360))
                .build();
    }

    // 随机生成速度
    private static Aeronaval.Velocity randomVelocity() {
        // 随机生成一个速度，东向、北向和垂直速度
        return Aeronaval.Velocity.newBuilder()
                .setEastVelocity(RAND.nextDouble() * 1000)
                .setNorthVelocity(RAND.nextDouble() * 1000)
                .setVerticalVelocity(RAND.nextDouble() * 500)
                .build();
    }
}
