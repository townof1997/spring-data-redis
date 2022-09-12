package com.bank.pro.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: com.bank.pro.reentrantlock
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 13 58
 */
public class AccountWithLock {
    private int balance;//余额
    private Lock lock;

    public AccountWithLock() {
        this.balance = 0;
        this.lock = new ReentrantLock();//构造初始化锁对象
    }
    public void lockAccount() {
        lock.lock();
    }
    public void unLockAccount() {
        lock.unlock();
    }

    public void login() {
        System.out.println("login");
    }

    public void add() {
        balance +=100;
        System.out.println("After add balance is:" + balance);
    }
    public void logout() {
        System.out.println("logout");
    }

    public synchronized void minus() {
        balance -= 800;
        System.out.println("After minus balance is:" + balance);
    }
}
