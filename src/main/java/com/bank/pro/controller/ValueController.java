package com.bank.pro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.bank.pro.springdataredis.controller
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 21 30
 */
@RestController
public class ValueController {
    @Value("${db.username}")
    private String username;

    @Value("${db.pwd}")
    private String pwd;

    @RequestMapping("/getParamFromValue")
    public String getParamFromValue() {
        return "db.username is:" + username + ",db.pwd is" + pwd;
    }
}
