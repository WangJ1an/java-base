package com.java.base;

/**
 * Created by 1 on 2017/3/2.
 */
public class Worker extends Person {

    public Worker() {}

    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Worker{"+getName()+" , "+getAge()+"}";
    }
}
