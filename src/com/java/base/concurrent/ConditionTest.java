package com.java.base.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 2017/3/12.
 */
public class ConditionTest {
    Lock lock = new ReentrantLock();
    Condition con1 = lock.newCondition();
    Condition con2 = lock.newCondition();
    Condition con3 = lock.newCondition();

    void print1() {
        lock.lock();
        try {
            System.out.println(1);
            System.out.println(2);
            System.out.println(3);
            con2.signal();
            con1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void print2() throws InterruptedException {
        try {
            con2.await();
            lock.lock();
            System.out.println(4);
            System.out.println(5);
            System.out.println(6);
            con3.signal();
        } finally {
            lock.unlock();
        }
    }

    void print3() {
        try {
            con3.await();
            lock.lock();
            System.out.println(7);
            System.out.println(8);
            System.out.println(9);
            con1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
