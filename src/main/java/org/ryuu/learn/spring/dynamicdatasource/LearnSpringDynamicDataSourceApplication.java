package org.ryuu.learn.spring.dynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.ryuu.learn.spring.dynamicdatasource.mapper")
@SpringBootApplication
public class LearnSpringDynamicDataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnSpringDynamicDataSourceApplication.class, args);
    }
}
