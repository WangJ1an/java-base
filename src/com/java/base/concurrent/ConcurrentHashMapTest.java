package com.java.base.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by 1 on 2017/8/5.
 */
public class ConcurrentHashMapTest {
    private final ConcurrentHashMap<String,Long> counter = new ConcurrentHashMap<>();

    public void increase(String url) {
        Long oldValue,newValue;
        while (true) {
            oldValue = counter.get(url);
            if (oldValue == null) {
                newValue = 1L;
                if (counter.putIfAbsent(url, newValue) == null) {
                    break;
                }
            } else {
                newValue = oldValue + 1;
                if (counter.replace(url,oldValue,newValue)) {
                    break;
                }
            }
        }
    }

    public long getCount(String url) {
        return counter.get(url);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ConcurrentHashMapTest test = new ConcurrentHashMapTest();
        int callTime = 100000;
        String url = "adsadasdsadas";
        CountDownLatch countDownLatch = new CountDownLatch(callTime);
        for (int i = 0; i < callTime; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    test.increase(url);
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(test.getCount(url));
    }

}
