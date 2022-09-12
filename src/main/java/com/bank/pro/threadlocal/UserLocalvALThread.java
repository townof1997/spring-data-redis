package com.bank.pro.threadlocal;

/**
 * @program: com.bank.pro.threadlocal
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 12 03
 */
public class UserLocalvALThread extends Thread {
    private MyThreadLocal local = new MyThreadLocal();
    public UserLocalvALThread(MyThreadLocal local) {
        this.local = local;
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " \t" + local.add());
        }
    }
}
