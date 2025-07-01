package utils;

import zb.dcts.aeronaval.Aeronaval;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Aeronaval.EquType, double[]> freqMap = new HashMap<>();
        freqMap.put(Aeronaval.EquType.AIRCAFT_EUT, new double[]{850e6, 950e6});
        freqMap.put(Aeronaval.EquType.SU27_EUT, new double[]{2.3e9, 2.5e9});
        freqMap.put(Aeronaval.EquType.JC_SHJJ_EUT, new double[]{1.1e9, 1.3e9});

        SignalTargetMatcher matcher = new SignalTargetMatcher(
                3.0,      // 时间阈值（秒）
                10.0,     // 空间距离（公里）
                20.0,     // DOA 误差角度（度）
                freqMap,
                4,        // 并发线程数
                "tcp://*:5560"  // ZMQ 发布地址
        );



        // 进行匹配并广播结果
//        List<TargetOuterClass.CombinedMessage> combined = matcher.matchAndPublish(surveyList, targetList);

        // 退出前释放资源
        matcher.shutdown();

    }
}
