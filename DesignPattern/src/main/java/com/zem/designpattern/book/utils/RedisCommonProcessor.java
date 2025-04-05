package com.zem.designpattern.book.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author zem
 * @Date 2023/11/12
 * @Describe
 */
@Component
public class RedisCommonProcessor {

    @Autowired
    private RedisTemplate redisTemplate;

    public Object get(String key) {
        if (key == null) {
            throw new UnsupportedOperationException("redis key could not be null");
        }
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * @param key
     * @param value
     * @param time  过期时间
     */
    public void set(String key, Object value, long time) {
        if (time > 0) {
            redisTemplate.opsForValue().set(key, value, time);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    public void remove(String orderId) {
        redisTemplate.delete(orderId);
    }
}
