package com.ggs.event.p1;

import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

import lombok.Data;

/**
 * @Author starbug
 * @Description 2233
 * @Datetime 2024/4/3 15:12
 */
@Data
public class BaseEvent<T> implements ResolvableTypeProvider {

    private T data;

    private String addOrUpdate;

    public BaseEvent(T data, String addOrUpdate) {
        this.data = data;
        this.addOrUpdate = addOrUpdate;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(), ResolvableType.forInstance(data));
    }

}
