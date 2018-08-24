package com.pyhis.orgmanagment.config;

import lombok.Data;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import java.util.ArrayList;
import java.util.List;


/**
 * redis配置类 这个 是否需要两个呢？？
 */
@Data
@Configuration
@Log4j2
@Component
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

//    @Value("${spring.redis2.host}")
//    private String host2;
//
//    @Value("${spring.redis2.port}")
//    private int port2;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    /**
     * 单redis配置
     * @return
     */
    @Bean
    public JedisPool redisPoolFactory() {
        log.info("JedisPool注入成功！！");
        log.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return jedisPool;
    }

    /**
     * 集群redis(double)配置 开发时 请注释掉这一块
     * @return
     */
//    @Bean
//    public ShardedJedisPool shardedRedisPoolFactory() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(maxIdle);
//        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
//        JedisShardInfo info1 = new JedisShardInfo(host, port, 1000 * 2);
//        info1.setPassword("123");
//        JedisShardInfo info2 = new JedisShardInfo(host2, port2, 1000 * 2);
//        info2.setPassword("123");
//        List<JedisShardInfo> infoList = new ArrayList<>();
//        infoList.add(info1);
//        infoList.add(info2);
//        ShardedJedisPool pool = new ShardedJedisPool(jedisPoolConfig,infoList, Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN);
//        log.info("{}个redis服务已联通",infoList.size());
//        return pool;
//    }




}
