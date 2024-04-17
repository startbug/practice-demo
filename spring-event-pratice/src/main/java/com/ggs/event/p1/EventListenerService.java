package com.ggs.event.p1;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/3 14:48
 */
@Slf4j
@Component
public class EventListenerService {

//    @EventListener
//    public <T> void handlePersonEvent(BaseEvent<T> baseEvent) throws JsonProcessingException {
//        T data = baseEvent.getData();
//        if (data instanceof Person) {
//            log.info("Person---------------{}", new ObjectMapper().writeValueAsString(data));
//        } else if (data instanceof Order) {
//            log.info("Order---------------{}", new ObjectMapper().writeValueAsString(data));
//        }
//    }

    @EventListener
    public void handlePersonEvent(BaseEvent<Person> baseEvent) throws JsonProcessingException {
        Person data = baseEvent.getData();
        log.info("Person---------------{}", new ObjectMapper().writeValueAsString(data));
    }

    @EventListener
    public void handleOrderEvent(BaseEvent<Order> baseEvent) throws JsonProcessingException {
        Order data = baseEvent.getData();
        log.info("Order---------------{}", new ObjectMapper().writeValueAsString(data));
    }

}
