package com.frank.bumyfamily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.frank.bumyfamily.dao")
public class BuMyfamilyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuMyfamilyApplication.class, args);
    }

}
