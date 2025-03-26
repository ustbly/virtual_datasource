package utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {
    private static final JedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);  // 最大连接数
        config.setMaxIdle(5);    // 最大空闲连接数
        config.setMinIdle(1);    // 最小空闲连接数
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

