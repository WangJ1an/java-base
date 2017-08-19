package com.java.base.concurrent;


/**
 * Created by 1 on 2017/8/6.
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set(Thread.currentThread().getName());

        System.out.println(threadLocal.get());
        Thread thread = new Thread() {
            @Override
            public void run() {
                threadLocal.set(Thread.currentThread().getName());
                System.out.println(threadLocal.get());
            }
        };
        thread.start();
        thread.join();
        System.out.println(threadLocal.get());

    }
}
