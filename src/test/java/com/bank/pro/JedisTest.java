package com.bank.pro;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: com.bank.pro
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/11 23 03
 */
public class JedisTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-redis.xml");
        JedisPool jedisPool = (JedisPool) context.getBean("jedisPool");
        Jedis jedis = jedisPool.getResource();
        jedis.select(0);
        System.out.println(jedis.get("30"));
        jedis.close();
    }
}
