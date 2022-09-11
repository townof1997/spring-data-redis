package com.bank.pro.controller;

/**
 * @program: com.bank.pro.springdataredis.controller
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 21 26
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {
    @Autowired
    private Environment environment;

    @RequestMapping("/getParam")
    public String getParam() {
        return "db.username is:" + environment.getProperty("db.username") +  ", db.pwd is:" + environment.getProperty("db.pwd");
    }
}
