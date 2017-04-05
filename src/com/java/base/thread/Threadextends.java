package com.java.base.thread;

/**
 * Created by 1 on 2017/2/6.
 */
public class Threadextends {
    public static void main(String []args){
        Demo1 demo1 = new Demo1("张山");
        Demo1 demo2 = new Demo1("李四");
        Demo1 demo3 = new Demo1("呵呵");
        Demo1 demo4 = new Demo1("王五");
        Demo1 demo5 = new Demo1("12312");
        demo5.start();
        demo4.start();
        demo3.start();
        demo2.start();
        demo1.start();
    }
}

class Demo1 extends Thread{
    private String name;

    Demo1(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int x = 1;x <= 10;x++)
            System.out.println(name+x+" "+Thread.currentThread().getName());
    }
}
