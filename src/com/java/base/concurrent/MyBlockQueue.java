package com.java.base.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 2017/7/31.
 */
public class MyBlockQueue<T> {
    private final Object[] items;
    private final ReentrantLock lock;
    private final Condition isEmpty;
    private final Condition isFull;
    private static int count,addIndex,removeIndex;

    public MyBlockQueue(int capacity) {
        this.items = new Object[capacity];
        this.lock = new ReentrantLock();
        this.isEmpty = lock.newCondition();
        this.isFull = lock.newCondition();
    }

    public void add(Object target) {
        lock.lock();
        try {
            while (count == items.length) {
                isFull.await();
            }
            items[addIndex] = target;
            if (++addIndex == items.length)
                addIndex = 0;
            count++;
            isEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                isEmpty.await();
            }
            Object x = items[removeIndex];
            if (++removeIndex == items.length)
                removeIndex = 0;
            count--;
            isFull.signal();
            return (T) x;
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        MyBlockQueue<Integer> queue = new MyBlockQueue<Integer>(10);
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    int num = 0;
                    try {
                        num = queue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(num);
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    queue.add(i);
                }
            }
        };

        thread1.start();
        thread2.start();
    }

}
