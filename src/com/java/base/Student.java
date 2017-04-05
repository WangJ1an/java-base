package com.java.base;

import java.io.Serializable;

/**
 * Created by 1 on 2017/3/2.
 */
public class Student extends Person implements Serializable {

    public Student(){}

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Student{"+this.getName()+" , "+this.getAge()+"}";
    }
}
