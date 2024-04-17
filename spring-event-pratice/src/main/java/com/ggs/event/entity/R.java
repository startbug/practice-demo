package com.ggs.event.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/17 16:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> ok(T data) {
        return R.<T>builder().code(200).msg("success").data(data).build();
    }

    public static <T> R<T> ok() {
        return R.<T>builder().code(200).msg("success").build();
    }

    public static <T> R<T> error() {
        return R.<T>builder().code(500).msg("error").build();
    }

    public static <T> R<T> error(String msg) {
        return R.<T>builder().code(500).msg(msg).build();
    }

}
