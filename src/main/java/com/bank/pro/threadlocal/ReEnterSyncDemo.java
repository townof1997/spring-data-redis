package com.bank.pro.threadlocal;




import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: com.bank.pro.threadlocal
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 12 25
 */
class SyncReEnter implements Runnable {

    ReentrantLock lock = new ReentrantLock();

    //synchronized会死锁，lock不会；
//    public synchronized void get() {
    public void get() {
//        lock.newCondition();
        lock.lock();
        System.out.println(Thread.currentThread().getId() + "\t");
        set();
        lock.unlock();
    }
    //public synchronized void set() {
    public void set() {
        lock.lock();
        System.out.println(Thread.currentThread().getId() + "\t");
        get();
        lock.unlock();
    }
    @Override
    public void run() {
        get();
    }
}

public class ReEnterSyncDemo {
    public static void main(String[] args) {
//        SyncReEnter demo = new SyncReEnter();
//        new Thread(demo).start();
//        new Thread(demo).start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        TaskRunnable task = new TaskRunnable();//Runnable的实现类
        Future<Integer> result = executorService.submit(task);//.execute(task);
        executorService.shutdown();
        Integer integer = 0;
        try {
            integer = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("" + integer);
//        Integer integer = result.get();
    }
}
