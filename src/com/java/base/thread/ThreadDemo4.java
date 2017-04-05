package com.java.base.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 2017/2/13.
 */
class Resource4 {
    private String name;

    private String sex;

    private boolean flag = false;

    private Lock lock = new ReentrantLock();

    private Condition con = lock.newCondition();

    public void set(String name,String sex){
        lock.lock();
        try {
            while (flag)
                try {
                    con.await();
                } catch (InterruptedException e) {
                }
            this.name = name;
            this.sex = sex;
            flag = true;
            con.signal();
        } finally {
            lock.unlock();
        }
    }
    public synchronized void out() {
        lock.lock();
        try {
            while (!flag)
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println(name + ".........." + sex);
            flag = false;
            con.signal();
        }finally {
            lock.unlock();
        }
    }
}
class Input implements Runnable{
    private Resource4 r;

    public Input(Resource4 resource4) {
        this.r = resource4;
    }
    @Override
    public void run(){
        int x = 0;
        while(true) {
            if (x == 0) {
                r.set("张飞", "男");
            } else if (x == 1) {
                r.set("Rose","女女女女女女");
            }
            x = (x + 1) % 2;
        }
    }
}

class Output implements Runnable{
    private Resource4 r;

    public Output(Resource4 resource4) {
        this.r = resource4;
    }
    @Override
    public void run(){
        while(true) {
            r.out();
        }
    }
}

public class ThreadDemo4 {
    public static void main(String[] args) {
        Resource4 r = new Resource4();
        Input input = new Input(r);
        Output output = new Output(r);
        Thread t1 = new Thread(input);
        Thread t2 = new Thread(output);
        t1.start();
        t2.start();
    }
}
