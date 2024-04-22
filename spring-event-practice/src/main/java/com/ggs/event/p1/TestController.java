package com.ggs.event.p1;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/3 14:47
 */
@Slf4j
@RestController
public class TestController {

    @Resource
    private ApplicationContext applicationContext;

    @GetMapping("/publishEvent")
    public void publishEvent() {
        applicationContext.publishEvent(new BaseEvent(new Person("starbug"), "add"));
        applicationContext.publishEvent(new BaseEvent(new Order("starbug"), "update"));
    }

}
