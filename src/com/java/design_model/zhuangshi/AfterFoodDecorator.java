package com.java.design_model.zhuangshi;

/**
 * Created by 1 on 2017/8/6.
 */
public class AfterFoodDecorator extends Decorator {
    private Order order;
    public AfterFoodDecorator(Order order) {
        this.order = order;
    }

    @Override
    public void printInfo() {
        order.printInfo();
        this.after();
    }

    public void after() {
        System.out.println("真的很好吃");
    }
}
