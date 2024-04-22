package com.ggs.event.p1;

import lombok.Data;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/3 15:13
 */
@Data
public class Order {

    private String orderNumber;

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
    }

}
