package com.java.base.thread;

/**
 * Created by 1 on 2017/8/2.
 */
public class DaemonThread {

    public static void main(String[] args) {
        System.out.println("主线程开始了");

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("线程"+Thread.currentThread().getName()+"开始了");
                while (true) {

                }
            }
        };
//        不设置为守护线程，虚拟机不会退出，因为有子线程存在，在while(true)无限循环
//        如果设置为守护线程的话，虚拟机等主线程执行完毕就会退出
//        thread.setDaemon(true);
        thread.start();
    }

}
