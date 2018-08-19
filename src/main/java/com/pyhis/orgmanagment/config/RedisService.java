package com.pyhis.orgmanagment.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 暂时放此  后面要移动
 */
@Log4j2
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
     * 设定Key value并指定有效时间
     * @param key
     * @param value
     * @return
     */
    public String set(String key,String value) {
        Jedis jedis = jedisPool.getResource();
        String str = "";
        try {
            str = jedis.set(key,value);
        } finally {
            try {
                if(jedis!=null){
                    jedis.close();
                }
            } catch (Exception e) {
                log.error("set key:{} value:{} error",key,value,e);
                e.printStackTrace();
            }
        }
        return str;
    }


    //获取key的value值
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String str = "";
        try {
            str = jedis.get(key);
        } finally {
            try {
                if(jedis!=null){
                    jedis.close();
                }

            } catch (Exception e) {
                log.error("get key:{}  error",key,e);
                e.printStackTrace();
            }
        }
        return str;
    }

    /**
     * 设定Key value并指定有效时间
     * @param key
     * @param exTime
     * @param value
     * @return
     */
    public String setEx(String key,String value,int exTime) {
        Jedis jedis = jedisPool.getResource();
        String str = "";
        try {
            str = jedis.setex(key,exTime,value);
        } finally {
            try {
                if(jedis!=null){
                    jedis.close();
                }
            } catch (Exception e) {
                log.error("set key:{} value:{} error",key,value,e);
                e.printStackTrace();
            }
        }
        return str;
    }

    /**
     * 设置key有效时间 单位是s
     * @param key
     * @param exTime
     * @return
     */
    public Long expire(String key,int exTime) {
        Jedis jedis = jedisPool.getResource();
        Long str = null;
        try {
            str = jedis.expire(key,exTime);
        } finally {
            try {
                if(jedis!=null){
                    jedis.close();
                }
            } catch (Exception e) {
                log.error("set key:{} value:{} error",key,e);
                e.printStackTrace();
            }
        }
        return str;
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public Long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long str = null;
        try {
            str = jedis.del(key);
        } finally {
            try {
                if(jedis!=null){
                    jedis.close();
                }

            } catch (Exception e) {
                log.error("del key:{}  error",key,e);
                e.printStackTrace();
            }
        }
        return str;
    }



}
