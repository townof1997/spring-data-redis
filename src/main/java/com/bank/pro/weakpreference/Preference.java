package com.bank.pro.weakpreference;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @program: com.bank.pro.weakpreference
 * @description: WeakPreference 可以用在网面文章的存储缓存，用户对象的优惠券过期无效等
 * @author: 86138_town
 * @create date: 2022/9/12 00 07
 */
public class Preference {

    public static void main(String[] args) {
        String a = new String("aaa");
        String b = new String("bbb");

        Map<String, String> map = new HashMap<>();
        Map<String, String> weakMap = new WeakHashMap<>();
        map.put(a, "aaa");
        map.put(b, "bbb");
        weakMap.put(a, "aaa");
        weakMap.put(b, "bbb");
        map.remove(a);
        a = null;
//        weakMap.remove(b);
        b = null;
        System.gc();
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry en = (Map.Entry) iterator.next();
            System.out.println("map: " + en.getKey() + " value:" +en.getValue());
        }
        Iterator iterator1 = weakMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("map: " + entry.getKey() + " value:" + entry.getValue());
        }

    }

}
