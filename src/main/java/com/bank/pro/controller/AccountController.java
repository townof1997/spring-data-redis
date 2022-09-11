package com.bank.pro.controller;

import com.bank.pro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @program: com.bank.newtouch.controller
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 20 29
 */
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/getAccountByID/{id}")
    public HashMap getAccountByID(@PathVariable String id) {
        return accountService.getAccountByID(id);
    }

    @RequestMapping(value = "/demoJSON/{id}", produces = ("application/json"))
    public HashMap demoJSON(@PathVariable String id) {
        HashMap hashMap = new HashMap();
        hashMap.put("ID", id);
        hashMap.put("balance", 1600);
        return hashMap;
    }

}
