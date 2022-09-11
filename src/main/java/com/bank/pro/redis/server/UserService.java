package com.bank.pro.redis.server;

import com.bank.pro.redis.bean.Users;
import com.bank.pro.redis.bean.UsersExample;
import com.bank.pro.redis.utils.SerializableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @program: com.imooc.aop.jedis.server
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 00 40
 */
@Service
public class UserService {

    @Autowired
    private JedisPool jedisPool;

    public List<Users> getUserList() {
        Jedis jedis = jedisPool.getResource();
        String username = jedis.get("username");
        List<Users> list = null;
        if (StringUtils.isEmpty(username)) {
            UsersExample usersExample = new UsersExample();
            list = null;//usersExample.selectByExample(usersExample);
//            jedis.set("username", list);
            jedis.set(SerializableUtils.serializable("username"), SerializableUtils.serializable(list));
        } else {
            list = (List<Users>) SerializableUtils.unSerializable(jedis.get(SerializableUtils.serializable("username")));

//            return list1;
        }
        jedis.close();


        return list;
    }
}
