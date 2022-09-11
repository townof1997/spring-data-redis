package com.bank.pro;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRedisApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringDataRedisApplication.class, args);
        //禁掉banner.txt日志的方法
        SpringApplication app = new SpringApplication(SpringDataRedisApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
