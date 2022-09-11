package com.bank.pro.redis;

//import redis.clients.jedis.Jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: com.bank.pro.redis
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 22 46
 */
public class JedisTest {
    public static void main(String[] args) {
//        Jedis j = new Jedis("127.0.0.1", 6379);
////        j.auth("");//在D:\software\Redis-x64-3.2.100\redis.windows.conf的第443行修改requirepass foobared，打开注释foobared即为密码
//        j.select(0);//默认就是0号库
//        j.set("username", "张三");
//
//        System.out.println(j.get("username"));
//
//        String id = j.hgetAll("offcn:1001").get("id");
//        String name = j.hgetAll("offcn:1001").get("name");
//        String mome = j.hgetAll("offcn:1001").get("mome");
//        String count = j.hgetAll("offcn:1001").get("count");
//        String price = j.hgetAll("offcn:1001").get("price");
//
//        System.out.println("id: " + id + " name:" + name + " mome:" + mome + " count:" + count + " price:" + price) ;
//        j.close();

        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.select(0);
        System.out.println(jedis.get("30"));
        jedis.close();


    }
}
