package com.bank.pro.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @program: com.bank.pro.semaphore
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 13 09
 */
public class SemaphoreDemo {

    //Semaphore 当线程数大于资源数时使用
    static class TaskThread extends Thread {

        Semaphore semaphore;

        public TaskThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                if (semaphore.availablePermits() > 0) {
                    System.out.println(getName() + " apply the connection");
                } else {
                    System.out.println(getName() + " no available");
                }
                System.out.println(getName() + " acquire");
                Thread.sleep(1000);
                semaphore.release();
                System.out.println(getName() + " release ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 5;
        Semaphore semaphore = new Semaphore(2, true);
        for (int i = 0; i < threadNum; i++) {
//            semaphore.acquire();;
//            Thread.sleep(1000);
            new TaskThread(semaphore).start();

        }
    }

}
