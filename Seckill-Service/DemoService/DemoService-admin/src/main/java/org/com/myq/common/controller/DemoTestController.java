package org.com.myq.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 毛一钦
 * @date 2023/6/25 18:56
 * @Description
 **/
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoTestController {


    @GetMapping(value = "/test", name = "接口测试")
    public String test(String param) {
        return UUID.randomUUID().toString() + File.separatorChar + param;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/test1", name = "接口测试1")
    public String test1(String param) {
        Set keys = redisTemplate.keys("*");
        redisTemplate.opsForValue().set(String.valueOf(Math.random() + "A毛"), "喵喵喵" + UUID.randomUUID(), 30L, TimeUnit.SECONDS);
        log.info("redis >>>>>>>>  {}", keys);
        int a = 1 / 0;
        return UUID.randomUUID().toString() + File.separatorChar + param;
    }

}
