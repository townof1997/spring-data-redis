package com.bank.pro.threadlocal;

/**
 * @program: com.bank.pro
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 11 59
 */
public class MyThreadLocal {
    private ThreadLocal<Integer> localVal = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer add() {
        localVal.set(localVal.get() + 1);
        return localVal.get() + 1;
    }
}
