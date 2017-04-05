package com.java.base.practice;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by 1 on 2017/2/22.
 */
public class ThreadTest {
    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();


    class MyRun0 implements Runnable {
        private String threadName;
        private int size = 0;
        public MyRun0(String threadName,int size) {
            this.threadName = threadName;
            this.size = size;
        }

        @Override
        public void run() {
            Insert();
        }

        public void Insert() {
            for (int i = size; i < 1000; i++) {
                arrayList.add(i);
            }
//            System.out.println(ThreadDemo.currentThread().getName()+"----------"+);
        }

        public synchronized void synInsert() {
            for (int i = size; i < 100; i++) {
                arrayList.add(i);
            }
//            System.out.println(ThreadDemo.currentThread().getName()+"----------"+size);
        }
    }

    void printArry(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args){
        //创建线程任务      内部类创建对象的方式
        MyRun0 myRun1 = new ThreadTest().new MyRun0("线程0",0);
        MyRun0 myRun2 = new ThreadTest().new MyRun0("线程1",50);
        MyRun0 myRun3 = new ThreadTest().new MyRun0("线程2",100);
        //创建线程
        Thread thread1 = new Thread(myRun1,myRun1.threadName);
        Thread thread2 = new Thread(myRun1,myRun2.threadName);
        Thread thread3 = new Thread(myRun1,myRun3.threadName);
        //开启线程
        thread1.start();
        thread2.start();
        thread3.start();
        //让主线程sleep，等待其余线程执行完向arrayList里添加了元素后再执行
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-----------------ArrayList:");
        //调用方法打印arrayList
        new ThreadTest().printArry(arrayList.iterator());
    }
}


