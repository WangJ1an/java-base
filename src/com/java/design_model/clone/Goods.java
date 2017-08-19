package com.java.design_model.clone;

/**
 * Created by 1 on 2017/8/6.
 */
public class Goods implements Cloneable {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Goods good = (Goods) super.clone();

        good.setName(this.name);
        good.setPrice(this.price);
        return good;
    }
}
