package com.java.base.exception;

/**
 * Created by 1 on 2017/2/4.
 */
public class Rectangle implements Shape {
    private double chang;

    private double kuan;

    private double shape;

    public Rectangle(double chang, double kuan) {
        if (chang <= 0 || kuan <= 0)
            throw new ShapeException("输入非法值");
        this.chang = chang;
        this.kuan = kuan;
    }

    @Override
    public double getArea(){
        shape = chang * kuan;
        return shape;
    }
}

