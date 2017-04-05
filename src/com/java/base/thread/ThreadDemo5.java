package com.java.base.thread;

/**
 * Created by 1 on 2017/2/19.
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        StopDemo sd = new StopDemo();
        Thread t1 = new Thread(sd);
        Thread t2 = new Thread(sd);
        t1.start();
        t2.start();
        int x = 0;
        while(true) {
             if(++x == 50){
                 t1.interrupt();
                 t2.interrupt();
                 break;
             }
             System.out.println(Thread.currentThread().getName() + "......"+x );
        }
    }
}

class StopDemo implements Runnable {
    private boolean flag = true;

    @Override
    public synchronized void run(){
        while(flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                Changeflage();
            }
            System.out.println(Thread.currentThread().getName() + "......" );
        }
    }

    public void Changeflage(){
        flag = false;
    }
}
