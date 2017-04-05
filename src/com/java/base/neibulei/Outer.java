package com.java.base.neibulei;

/**
 * Created by 1 on 2017/1/17.
 */
public class Outer {
    public int a = 3;

    public class Inner{
        public int a = 4;

        public void function(){
            a = 5;
            System.out.println("Inter: "+ a);
        }
    }

    public void method(){
        Inner inner = new Inner();
        inner.function();
    }
}
