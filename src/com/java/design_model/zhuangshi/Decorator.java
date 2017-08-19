package com.java.design_model.zhuangshi;

/**
 * Created by 1 on 2017/8/6.
 */
public abstract class Decorator implements Order {
    protected Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public void printInfo() {
        this.order.printInfo();
    }
}
