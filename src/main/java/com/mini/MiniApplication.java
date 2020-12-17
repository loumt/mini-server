package com.mini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Filename: MiniApplication
 * @Description: Mini Application
 * @Version: 1.0.0
 * @Author: louMT
 * @Email: LouMT@keeson.com
 * @Date: 2020-11-09 19:54
 */
@SpringBootApplication
public class MiniApplication {

    public static void main(String[] args) {
        SpringApplication application= new SpringApplication(MiniApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
