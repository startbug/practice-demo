package com.ggs.event.p1;

import lombok.Data;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/3 14:46
 */
@Data
public class PersonEvent {

    private Person person;

    private String addOrUpdate;

    public PersonEvent(Person person, String addOrUpdate) {
        this.person = person;
        this.addOrUpdate = addOrUpdate;
    }
}
