package com.java.base.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by 1 on 2017/3/19.
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(1);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class Producer implements Runnable {

    private ArrayBlockingQueue queue = null;

    public Producer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(2000);
            queue.put("3");
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private ArrayBlockingQueue queue = null;

    public Consumer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (Exception e) {
            e.toString();
        }
    }
}
