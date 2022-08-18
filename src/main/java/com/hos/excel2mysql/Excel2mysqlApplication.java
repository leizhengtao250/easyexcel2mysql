package com.hos.excel2mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@MapperScan("com.hos.excel2mysql.mapper")
public class Excel2mysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Excel2mysqlApplication.class, args);
    }

}
