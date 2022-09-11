package com.bank.pro.redis.utils;

import java.io.*;

/**
 * @program: com.bank.pro.redis.utils
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 00 54
 */
public class SerializableUtils {

    public static byte[] serializable(Object object) {
        if (null == object) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Object unSerializable(byte[] bytes) {
        if (null == bytes) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
