package com.bank.pro.redis.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: com.imooc.aop.jedis.bean
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 00 41
 */
@Data
public class Users implements Serializable {
    private String id;
    private String name;
    private String password;
}
