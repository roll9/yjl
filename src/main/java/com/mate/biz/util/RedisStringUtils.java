package com.mate.biz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisStringUtils {

    private static final Logger logger = LoggerFactory.getLogger(RedisStringUtils.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //普通set方法
    public boolean setString(String key, String value){
        try{
            stringRedisTemplate.opsForValue().set(key, value);
            return true;
        }catch (Exception e){
            logger.error("redis setString操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    //普通get方法
    public String getString(String key){
        try{
            return stringRedisTemplate.opsForValue().get(key);
        }catch (Exception e){
            logger.error("redis getString操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    //删除方法
    public boolean del(String key){
        try{
            return stringRedisTemplate.delete(key);
        }catch (Exception e){
            logger.error("redis del操作发生异常,key:" + key);
            logger.error(e.getMessage(), e);
            return false;
        }
    }

}
