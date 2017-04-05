package com.java.base.exception;

/**
 * Created by 1 on 2017/2/4.
 */
public class Demo {
    public static void main (String []args){
        Circular circular = new Circular(4);
        Rectangle rectangle = new Rectangle(-4,2);
        System.out.println(circular.getArea());
        System.out.println("over");
    }
}
