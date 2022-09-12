package com.bank.pro.reentrantlock;

import com.bank.pro.threadlocal.UserLocalvALThread;

/**
 * @program: com.bank.pro.reentrantlock
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 14 08
 */
public class AddThreadWithLock extends Thread {
    private String person;
    AccountWithLock acc;

    public AddThreadWithLock(String person, AccountWithLock acc) {
        this.person = person;
        this.acc = acc;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 3; i++) {
            acc.lockAccount();
            System.out.println(person + "add money, " + i + "count");
            acc.login();
            System.out.println(person + " login");
            acc.add();
            System.out.println(person + " logout");
            acc.logout();
            acc.unLockAccount();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new AddThreadWithLock("张三", new AccountWithLock());
//        Thread t2 = new AddThreadWithLock("李四", new AccountWithLock());
//        Thread t3 = new AddThreadWithLock("王五", new AccountWithLock());
        t1.start();
//        t2.start();
//        t3.start();
    }
}
