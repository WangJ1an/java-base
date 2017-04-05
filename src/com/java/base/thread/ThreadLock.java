package com.java.base.thread;

/**
 * Created by 1 on 2017/2/9.
 */
class Test implements Runnable {
    private boolean flag;

    public Test(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if (flag) {
            synchronized (MyLock.LOCKA) {
                System.out.println(Thread.currentThread().getName() + "....if.....loackA");
                synchronized (MyLock.LOCKB) {
                    System.out.println(Thread.currentThread().getName() + "....if.....loackB");
                }
            }
        } else {
            synchronized (MyLock.LOCKB) {
                System.out.println(Thread.currentThread().getName() + "....if.....loackB");
                synchronized (MyLock.LOCKA) {
                    System.out.println(Thread.currentThread().getName() + "....if.....loackA");
                }
            }
        }
    }
}

 class MyLock {
        public static final Object LOCKA = new Object();
        public static final Object LOCKB = new Object();
 }


public class ThreadLock {
        public static void main(String[] args) {
            Test test1 = new Test(true);
            Test test2 = new Test(false);
            Thread t1 = new Thread(test1);
            Thread t2 = new Thread(test2);
            t1.start();
            t2.start();
        }
}



