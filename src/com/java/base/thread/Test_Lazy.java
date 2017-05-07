package com.java.base.thread;

/**
 * Created by 1 on 2017/4/13.
 */
public class Test_Lazy {

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(LazyDemo.getInstance().hashCode());
                }
            }.start();
        }
    }
}
