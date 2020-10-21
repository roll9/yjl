package com.mate.biz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    //普通set方法
    public boolean set(String key, Object value){
        try{
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch (Exception e){
            logger.error("redis set操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    //普通get方法
    public Object get(String key){
        try{
            return redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            logger.error("redis get操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    //set方法,设置超时时间
    public boolean set(String key, Object value, long seconds){
        try{
            redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            logger.error("redis set操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    //删除方法
    public boolean del(String key){
        try{
            return redisTemplate.delete(key);
        }catch (Exception e){
            logger.error("redis del操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    //获取hash结构的数据
    public Object hget(String key, String field){
        try{
            return redisTemplate.opsForHash().get(key, field);
        }catch (Exception e){
            logger.error("redis hget操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    //设置hash结构的数据
    public boolean hset(String key, String field, Object value){
        try{
            redisTemplate.opsForHash().put(key, field, value);
            return true;
        }catch (Exception e){
            logger.error("redis hset操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return false;
        }
    }

}
