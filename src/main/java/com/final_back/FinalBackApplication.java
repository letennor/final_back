package com.final_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.final_back.mapper")
public class FinalBackApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinalBackApplication.class, args);
    }

}
