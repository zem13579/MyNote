package com.zem.designpattern.book.cfg;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2023/11/26 0026
 */
@Component
@Slf4j
public class CheckEnv {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @PostConstruct
    @Async
    public void testRdies() {
        log.info("开始检查 redis 链接");
        try {
            redisTemplate.opsForValue().set("test", "test");
            Object test = redisTemplate.opsForValue().get("test");
            if (test instanceof String str && str.equals("test")) {
                System.out.println("redis 链接正常");
            } else {
                throw new Exception("redis 链接异常");
            }
        } catch (Exception e) {
            log.error("redis 链接异常,摘要"+e.getMessage());
            // todo 将连接地址重置为本地的localhost后重试

        }

    }



}
