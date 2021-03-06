package org.hthu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {

    //声明成static的原因：保证jedis连接池在tomcat启动时就加载出来
    //jedis连接池
    private static JedisPool pool;
    //与redis连接池连接的最大连接数
    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.max.total", "20"));
    //在这个连接池中最多有多少个状态为idle的jedis实例，jedis连接池里就是jedis的实例，idle就是空闲的jedis实例
    //在jedis连接池中最大的idle状态（空闲的）的jedis实例的个数
    private static Integer maxIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.max.idle", "10"));
    //在jedis连接池中最小的idle状态（空闲的）的jedis实例的个数
    private static Integer minIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.min.idle", "2"));

    //在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值为true，则得到的jedis实例肯定是可用的
    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.borrow", "true"));
    //在return一个jedis实例的时候，是否要进行验证操作，如果赋值为true，则返回jedis连接池的jedis实例肯定是可用的
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.return", "true"));

    private static String redisIp = PropertiesUtil.getProperty("redis.ip");
    private static Integer redisPort = Integer.parseInt(PropertiesUtil.getProperty("redis.port"));

    //初始化连接池，只会调用一次
    private static void initPool() {
        JedisPoolConfig jedisConfig = new JedisPoolConfig();

        jedisConfig.setMaxTotal(maxTotal);
        jedisConfig.setMaxIdle(maxIdle);
        jedisConfig.setMinIdle(minIdle);

        jedisConfig.setTestOnBorrow(testOnBorrow);
        jedisConfig.setTestOnReturn(testOnReturn);

        //连接池耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时，会抛出超时异常，默认为true
        jedisConfig.setBlockWhenExhausted(true);

        //这里超时时间是2s
        pool = new JedisPool(jedisConfig, redisIp, redisPort, 1000*2);

    }

    static {
        initPool();
    }

    //从连接池中拿取一个实例
    public static Jedis getJedis() {
        return pool.getResource();
    }

    //将正常实例放回jedis连接池
    public static void returnResource(Jedis jedis) {
//        pool.returnResource(jedis);
        pool.close();
    }

    //将破损实例放回jedis连接池
    public static void returnBrokenResource(Jedis jedis) {
//        pool.returnResource(jedis);
        pool.close();
    }

}
