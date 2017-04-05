package com.java.base.reflect.test;

/**
 * Created by 1 on 2017/3/13.
 */
public class MouseByUSB implements USB {

    @Override
    public void open() {
        System.out.println("Mouse is open");
    }

    @Override
    public void close() {
        System.out.println("Mouse is close");
    }
}
