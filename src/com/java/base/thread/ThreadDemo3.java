package com.java.base.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 2017/2/9.
 */
//1.描述资源，属性，商品名称，编号。行为：对商品名称赋值，获取商品。
class Resource {
    private String name;

    private boolean flag = false;

    private Lock lock = new ReentrantLock();

    private Condition con = lock.newCondition();

    private Condition pro = lock.newCondition();

    private Resource []res = new Resource[10];

    private int proptr,conptr,count;

    //提供设置方法
    public void set(String name) {
        lock.lock();
        try {
            while (flag)
                try {
                    pro.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            //给成员变量赋值并加上编号
            this.name = name + count;
            //编号自增
            count++;
            //打印生产了哪个商品
            System.out.println(Thread.currentThread().getName() + "....生产者...." + this.name);
            flag = true;
            con.signal();
        } finally {
            lock.unlock();
        }
    }

    public void out() {
        lock.lock();
        try {
            while (!flag)
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println(Thread.currentThread().getName() + "....消费者...." + this.name);
            flag = false;
            pro.signal();
        } finally {
            lock.unlock();
        }
    }
}

//2.描述生产者
class Producer implements Runnable {
    private Resource resource;

    public Producer (Resource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        while (true) {
                resource.set("面包");
        }
    }
}

//3.描述消费者。
class Consumer implements Runnable{
    private Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run(){
        while (true) {
                resource.out();
        }
    }
}

public class ThreadDemo3 {
    public static void main(String []args){
        //1.创建资源对象
        Resource resource = new Resource();

        //2.创建线程任务
        Producer pro1 = new Producer(resource);
        Producer pro2 = new Producer(resource);
        Consumer con1 = new Consumer(resource);
        Consumer con2 = new Consumer(resource);

        //3.创建线程
        Thread t1 = new Thread(pro1);
        Thread t2 = new Thread(con1);
        Thread t3 = new Thread(pro2);
        Thread t4 = new Thread(con2);

        //4.开启线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
