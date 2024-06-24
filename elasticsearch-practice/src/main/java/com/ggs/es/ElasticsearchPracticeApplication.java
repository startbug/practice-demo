package com.ggs.es;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ggs.es.mapper")
@SpringBootApplication
public class ElasticsearchPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchPracticeApplication.class, args);
    }

}
