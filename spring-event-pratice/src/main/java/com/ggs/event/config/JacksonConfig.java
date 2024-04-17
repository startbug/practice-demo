package com.ggs.event.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

/**
 * @Author starbug
 * @Description
 * @Datetime 2024/4/17 17:18
 */
@Configuration
public class JacksonConfig {

    @Value("${spring.mvc.format.date-time}")
    private String dateTimeFormat;

    @Value("${spring.mvc.format.date}")
    private String dateFormat;

    @Value("${spring.mvc.format.time}")
    private String timeFormat;

    @Bean
    public ObjectMapper objectMapper() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeFormat);
        return Jackson2ObjectMapperBuilder.json()
                .serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter))
                .serializerByType(LocalDate.class, new LocalDateSerializer(dateFormatter))
                .serializerByType(LocalTime.class, new LocalTimeSerializer(timeFormatter))
                .deserializers(new LocalDateTimeDeserializer(dateTimeFormatter))
                .deserializers(new LocalDateDeserializer(dateFormatter))
                .deserializers(new LocalTimeDeserializer(timeFormatter))
                .build();
    }

}
