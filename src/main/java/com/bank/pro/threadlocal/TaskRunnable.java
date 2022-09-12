package com.bank.pro.threadlocal;

import java.util.concurrent.Callable;

/**
 * @program: com.bank.pro.threadlocal
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 12 53
 */
public class TaskRunnable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("in task");
        Thread.sleep(2000);
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            sum += i;
        }
        return sum;
    }
}
