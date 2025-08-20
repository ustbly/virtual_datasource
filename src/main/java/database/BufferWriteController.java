package database;

import zb.dcts.aeronaval.Aeronaval;
import zb.dcts.scenario.detection.Detection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 林跃
 * @file BufferWriteController.java
 * @comment 用于批量写入 Target 和 SignalLayerSurvey 数据到数据库。
 * 通过线程安全的缓存队列和定时任务实现自动批量入库。
 * @date 2025/7/11
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class BufferWriteController {
    // 批次大小
    private final int batchSize;
    // 数据库连接对象
    private final Connection connection;
    // 线程安全队列
    private final BlockingQueue<Aeronaval.Target> targetQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<Detection.SignalLayerSurvey> surveyQueue = new LinkedBlockingQueue<>();
    // 定时任务调度器
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();


    /**
     * 构造函数
     * @param conn 数据库连接对象
     * @param batchSize 批量写入的大小
     * @comment 初始化缓冲写控制器，并启动自动刷新任务
     */
    public BufferWriteController(Connection conn, int batchSize) {
        this.connection = conn;
        this.batchSize = batchSize;
        startAutoFlush();  // 启动定时任务
    }

    /**
     * 添加目标对象到缓存队列
     * @param target Aeronaval.Target类型的目标对象
     * @comment 将目标对象添加到队列中，当队列大小达到批次大小时触发批量写入
     *         使用offer操作确保线程安全，由于队列无界，不会发生数据丢失
     */
    public void addTarget(Aeronaval.Target target) {
        // offer 返回值忽略：队列为无界，永不丢失
        targetQueue.offer(target);
        if (targetQueue.size() >= batchSize) {
            flushTargets();
        }
    }

    /**
     * 添加信号层策略结果到缓存队列
     * @param survey Detection.SignalLayerSurvey类型的调查对象
     * @comment 将调查对象添加到队列中，当队列大小达到批次大小时触发批量写入
     */
    public void addSurvey(Detection.SignalLayerSurvey survey) {
        surveyQueue.offer(survey);
        if (surveyQueue.size() >= batchSize) {
            flushSurveys();
        }
    }


    /**
     * 刷新所有缓存队列
     * @comment 强制将两个队列中的所有数据写入数据库
     */
    public void flushAll() {
        flushTargets();
        flushSurveys();
    }

    /**
     * 刷新目标对象队列
     * @comment 将targetQueue中的数据批量写入数据库
     *         使用drainTo方法一次性获取多个元素，保证原子性
     *         如果写入失败，会打印错误信息但不会抛出异常
     */
    private void flushTargets() {
        List<Aeronaval.Target> batch = new ArrayList<>();
        targetQueue.drainTo(batch, batchSize);
        if (!batch.isEmpty()) {
            try {
                TargetDBWriter.batchInsertTargets(connection, batch);
                System.out.println("[写入] Target 批量入库: " + batch.size() + " 条");
            } catch (SQLException e) {
                System.err.println("[错误] Target 批量写入失败: " + e.getMessage());
            }
        }
    }

    /**
     * 刷新信号层测量结果队列
     *
     * @comment 将surveyQueue中的数据批量写入数据库
     * 使用drainTo方法一次性获取多个元素，保证原子性
     * 如果写入失败，会打印错误信息但不会抛出异常
     */
    private void flushSurveys() {
        List<Detection.SignalLayerSurvey> batch = new ArrayList<>();
        surveyQueue.drainTo(batch, batchSize);
        if (!batch.isEmpty()) {
            try {
                SignalLayerSurveyDBWriter.batchInsertSurveys(connection, batch);
                System.out.println("[写入] SignalLayerSurvey 批量入库: " + batch.size() + " 条");
            } catch (SQLException e) {
                System.err.println("[错误] Survey 批量写入失败: " + e.getMessage());
            }
        }
    }


    /**
     * 启动自动刷新任务
     *
     * @comment 初始化一个定时任务，每3秒执行一次刷新操作
     * 首次执行延迟10秒，这样可以让系统先完成其他初始化工作
     * 使用scheduleAtFixedRate确保固定频率执行，即使某次执行时间较长
     */
    private void startAutoFlush() {
        scheduler.scheduleAtFixedRate(this::flushAll, 10, 3, TimeUnit.SECONDS);
    }


    /**
     * 关闭控制器
     *
     * @comment 终止定时任务调度器，并执行最后一次刷新
     * 确保所有数据都被写入数据库
     * 应在程序结束时调用此方法
     */
    public void shutdown() {
        scheduler.shutdownNow();
        flushAll();
    }
}