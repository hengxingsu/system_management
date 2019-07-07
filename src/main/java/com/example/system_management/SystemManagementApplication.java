package com.example.system_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.example.system_management.dao")

public class SystemManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemManagementApplication.class, args);
    }

}
