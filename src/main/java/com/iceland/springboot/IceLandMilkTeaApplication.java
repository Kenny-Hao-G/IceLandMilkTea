package com.iceland.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @date 2019-10-22 2:49 下午
 * @version 1.1
 * @IceLandMilkTeaApplication SpringBoot启动类
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.iceland.springboot.dao")
@ComponentScan("com.iceland")
public class IceLandMilkTeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(IceLandMilkTeaApplication.class, args);
    }



}
