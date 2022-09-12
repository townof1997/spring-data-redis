package com.bank.pro.finalize;

/**
 * @program: com.bank.pro.finalize
 * @description:
 * @author: 86138_town
 * @create date: 2022/9/12 11 26
 */
public class FinalizeDemo {
    public static FinalizeDemo obj = null;
    //重写Object里的finalize()方法
    protected void finalize() throws Throwable {
        System.out.println("In finalize");
        obj = this;
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new FinalizeDemo();
        obj = null;//去掉强引用
        System.gc();//垃圾回收
        //sleep 1秒，以便垃圾回收线程清理obj对象
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("FinalizeDeno Not alive");
        } else {
            System.out.println("FinalizeDemo still alive");
        }
    }
}
