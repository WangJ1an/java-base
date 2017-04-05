package com.java.base.exception;


/**
 * Created by 1 on 2017/2/4.
 */
public class Circular implements Shape {
    private double R;
    private static final double PI = 3.14;

    Circular(double R){
        if (R <= 0)
            throw new ShapeException("输入半径非法");
        this.R = R;
    }

    @Override
    public double getArea() {
        return PI * (R * R);
    }

}
