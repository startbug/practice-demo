package com.ggs.event.p1;

import lombok.Data;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/3 14:46
 */
@Data
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

}
