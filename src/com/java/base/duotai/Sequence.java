package com.java.base.duotai;

/**
 * Created by 1 on 2017/8/2.
 */
public class Sequence {
    private static class A {
        private int i = 6;

        A(){
//            i = 5;
        }

        {
            i = 2;
        }

    }

    public static void main(String[] args) {

        A a = new A();
        System.out.println(a.i);
    }
}
