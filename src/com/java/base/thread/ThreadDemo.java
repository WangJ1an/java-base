package com.java.base.thread;

/**
 * Created by 1 on 2017/2/7.
 */
public class ThreadDemo {
    public static void main(String []args){
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);
        Thread thread4 = new Thread(ticket);
        Thread thread5 = new Thread(ticket);
        Thread thread6 = new Thread(ticket);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        }
}

class Ticket implements Runnable {
    private int tickets = 100;

    private Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized(obj) {
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "......." + tickets--);
                }
            }
        }
    }
}
