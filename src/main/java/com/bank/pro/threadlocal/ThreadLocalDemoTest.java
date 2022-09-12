package com.bank.pro.threadlocal;

/**
 * @program: com.bank.pro.threadlocal
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 13 33
 */
public class ThreadLocalDemoTest {
    public static void main(String[] args) {
        MyThreadLocal threadLocal = new MyThreadLocal();
        Thread t1 = new UserLocalvALThread(threadLocal);
        Thread t2 = new UserLocalvALThread(threadLocal);
        Thread t3 = new UserLocalvALThread(threadLocal);
        t1.start();
        t2.start();
        t3.start();
    }

}
