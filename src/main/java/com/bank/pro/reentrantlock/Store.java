package com.bank.pro.reentrantlock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: com.bank.pro.reentrantlock
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 14 24
 */
public class Store {
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;
    private int maxSize;
    private LinkedList<String> stroage;

    public Store(int maxSize) {
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        this.maxSize = maxSize;
        stroage = new LinkedList<>();
    }

    public void product() throws InterruptedException {
        lock.lock();
        while (stroage.size() == maxSize) {
            System.out.println(Thread.currentThread().getName() + ":wait");
            try {
                notFull.await();
                stroage.add("Java Book");
                System.out.println(Thread.currentThread().getName() + ":put:" + stroage.size());
                Thread.sleep(100);
                //唤醒消费线程
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
    public void consume() {
        lock.lock();
        while (stroage.size() == 0) {
            System.out.println(Thread.currentThread().getName() + ":wait");
            try {
                notEmpty.await();
                //取出消费
                System.out.println(stroage.poll());
                System.out.println(Thread.currentThread().getName() + ":left:" + stroage.size());
                Thread.sleep(1000);
                notFull.signalAll();//唤醒生产线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}
