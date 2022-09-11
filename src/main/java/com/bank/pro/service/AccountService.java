package com.bank.pro.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @program: com.bank.newtouch.service
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 20 28
 */
@Service
public class AccountService {

    public HashMap getAccountByID(String id) {
        HashMap hashMap = new HashMap();
        hashMap.put("ID", id);
        hashMap.put("balance", 1500);
        return hashMap;
    }
}
