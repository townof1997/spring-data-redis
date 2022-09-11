package com.bank.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.bank.pro.springdataredis.controller
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 21 50
 */
@RestController
public class TestController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello";
    }
}
