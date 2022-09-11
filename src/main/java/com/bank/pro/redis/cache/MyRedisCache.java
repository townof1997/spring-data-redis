package com.bank.pro.redis.cache;

//import org.springframework.cache.Cache;

import com.bank.pro.redis.utils.SerializableUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: com.bank.pro.redis.cache
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 01 28
 */
public class MyRedisCache implements Cache {


    private String id;
    private JedisPool jedisPool;
    public MyRedisCache(String id) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-redis.xml");
        context.getBean(JedisPool.class);
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object o, Object o1) {
        Jedis resource = jedisPool.getResource();
        resource.set(SerializableUtils.serializable(o),SerializableUtils.serializable(o1));
        resource.close();

    }

    @Override
    public Object getObject(Object o) {
        Jedis resource = jedisPool.getResource();
        Object o1 = SerializableUtils.unSerializable(resource.get(SerializableUtils.serializable(o)));
        resource.close();
        return o1;
    }

    @Override
    public Object removeObject(Object o) {
        Jedis jedis = jedisPool.getResource();
        Object o1 = SerializableUtils.unSerializable(jedis.get(SerializableUtils.serializable(o)));
        jedis.expire(SerializableUtils.serializable(o), 0);
        jedis.close();
        return o1;
    }

    @Override
    public void clear() {
        Jedis jedis = jedisPool.getResource();
        jedis.flushDB();
        jedis.close();
    }

    @Override
    public int getSize() {
        Jedis jedis = jedisPool.getResource();
        Long aLong = jedis.dbSize();
//        int length = (int)aLong;
        jedis.close();
        return aLong.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        return lock;
    }
}
