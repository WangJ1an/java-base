package com.java.base.concurrent;

import java.util.concurrent.*;

/**
 * Created by 1 on 2017/3/19.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 10; i++) {
            final int task = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " is Loop of " + j + " for task of " + task);
                    }
                }
            });
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("All of 10 tasks have committed");
        threadPool.shutdown();

        //定时器演示
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("bombing!");
                    }
                }
        ,6,2,TimeUnit.SECONDS);

    }
}
