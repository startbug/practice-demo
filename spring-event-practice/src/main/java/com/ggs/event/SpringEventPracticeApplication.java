package com.ggs.event;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ggs.event.mapper")
public class SpringEventPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEventPracticeApplication.class, args);
	}

}
