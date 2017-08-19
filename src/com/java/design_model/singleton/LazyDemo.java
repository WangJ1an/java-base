package com.java.design_model.singleton;

/**
 * Created by 1 on 2017/4/11.
 */
public class LazyDemo {
//    延迟加载|懒汉模式
    private static volatile LazyDemo lazyDemo;

    public static LazyDemo getInstance() {
        //此方法不做同步处理的话，多线程访问会出现多例的情况
/*
        if (lazyDemo == null) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazyDemo = new LazyDemo();
        } else ;
*/

        if (lazyDemo == null) {
            synchronized (LazyDemo.class) {
                if (lazyDemo == null) { //使用双重检查的方法实现单例
                    lazyDemo = new LazyDemo();
                }
            }
        }
        return lazyDemo;
    }

    //采用静态内部类方式创建线程安全单例,静态内部类只在被引用时加载一次
    private static class SingletonHolder {
        private static final LazyDemo singleton = new LazyDemo();
    }

    private static LazyDemo getSingleton() {
        return SingletonHolder.singleton;
    }



    private LazyDemo() {}

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
