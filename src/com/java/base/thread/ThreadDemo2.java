package com.java.base.thread;

/**
 * Created by 1 on 2017/2/8.
 */
class Bank {
    private int sum;

    public void add(int num){
        sum = sum + num;
        System.out.println(sum);
    }
}

class Client implements Runnable {
    private Bank b = new Bank();
    private Object obj = new Object();
    @Override
    public void run(){
        for(int x = 0;x < 3;x++){
            synchronized(obj) {
                b.add(100);
            }
        }
    }
}

public class ThreadDemo2 {
    public static void main(String []args){
        Client c = new Client();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();

    }
}
