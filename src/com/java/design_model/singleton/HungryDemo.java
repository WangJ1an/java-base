package com.java.design_model.singleton;

/**
 * Created by 1 on 2017/4/11.
 */
public class HungryDemo {
    //立即加载|饿汉模式
    private static final HungryDemo hungryDemo = new HungryDemo();

    public static HungryDemo getInstance() {
        return hungryDemo;
    }

    //构造器私有
    private HungryDemo() {}

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(HungryDemo.getInstance().hashCode());
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
