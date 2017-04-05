package com.java.base.concurrent;

/**
 * Created by 1 on 2017/3/19.
 */
public class VolatileTest implements Runnable {

    volatile int n = 0;

    @Override
    public void run() {
        for (int i = 0; i< 10; i++) {
            try {
                n = n + 1;
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        Thread threads[] = new Thread[100];
        VolatileTest vt = new VolatileTest();
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(vt);
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //结果不为1000.声明为volatile的变量如果当前值与该变量以前的值相关，那么volatile不起作用，如n = n+1；
        //n++ 等，如果想要使这种情况变为原子的，则要使用synchronized关键字；
        System.out.println("n = "+vt.n);
    }
}
