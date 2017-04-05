package com.java.base.thread;

/**
 * Created by 1 on 2017/2/7.
 */
public class ThreadRunnable {
    public static void main(String []args){
        Demo2 d = new Demo2();

        Thread t = new Thread(d);

        t.start();

    }
}
class Demo2 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" ");
    }
}
