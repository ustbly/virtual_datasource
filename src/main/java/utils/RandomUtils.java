package utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @file RandomUtils.java
 * @comment 生成随机数的工具类
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */
public class RandomUtils {

    // 生成 [min, max) 范围的浮点数，并保留指定小数位数
    public static double nextDouble(double min, double max, int scale) {
        double raw = ThreadLocalRandom.current().nextDouble(min, max);
        double factor = Math.pow(10, scale);
        return Math.round(raw * factor) / factor;
    }

    // 生成 [min, max] 范围的整数
    public static int nextInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
