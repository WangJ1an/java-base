package com.java.base.thread;

/**
 * Created by 1 on 2017/4/11.
 */
public class LazyDemo {
//    延迟加载|懒汉模式
    private static LazyDemo lazyDemo;

    public static LazyDemo getInstance() {
        //此方法不做同步处理的话，多线程访问会出现多例的情况
        /*if (lazyDemo == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazyDemo = new LazyDemo();
        } else ;*/

        if (lazyDemo == null) {

            synchronized (LazyDemo.class) {
                if (lazyDemo == null) { //使用双重检查的方法实现单例
                    lazyDemo = new LazyDemo();
                }
            }
        }
        return lazyDemo;
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(LazyDemo.getInstance().hashCode());
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
