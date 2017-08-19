package com.java.design_model.zhuangshi;

/**
 * Created by 1 on 2017/8/6.
 */
public class PreviousFoodDecorator extends Decorator {
    private Order order;
    public PreviousFoodDecorator(Order order) {
        this.order = order;
    }
    @Override
    public void printInfo() {
        this.previous();
        order.printInfo();
    }

    private void previous() {
        System.out.println("食品类----商品");
    }
}
