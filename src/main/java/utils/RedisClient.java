package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @file RedisClient.java
 * @comment Redis数据库的工具类
 * @date 2025/4/21
 * @author 林跃
 * @copyright Copyright (c) 2021  中国电子科技集团公司第四十一研究所
 */

public class RedisClient {
    private static final JedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);  // 最大连接数
        config.setMaxIdle(5);    // 最大空闲连接数
        config.setMinIdle(1);    // 最小空闲连接数
        config.setMaxWait(Duration.ofDays(-1));
        pool = new JedisPool(config, "node1", 6379, 2000,"123456");
    }

    public static Jedis getJedis() {
        Jedis jedis = pool.getResource();
        return jedis;
    }

    public static void close() {
        pool.close();
    }
}

