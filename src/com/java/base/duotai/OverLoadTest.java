package com.java.base.duotai;

/**
 * Created by 1 on 2017/3/23.
 */
public class OverLoadTest {
    public static void main(String[] args) {
        A ab = new B();
        A a = new A();
        B b = new B();
        C c = new C();
        a.show(a);
        ab.show(ab);
        ab.show(b);
        ab.show(c);
    }
//   能调用哪些方法，由引用类型决定（即静态类型），具体执行情况，由实际内存对象类型决定
}
class A {

    public void show(A a) {
        System.out.println("A and A");
    }

//    public void show(B b) {
//        System.out.println("A and B");
//    }

    public void show(C C) {
        System.out.println("A and C");
    }
}

class B extends A {
  /*  @Override
    public void show(A a) {
        System.out.println("B and A");
    }*/

   /* @Override
    public void show(B b) {
        System.out.println("B and B");
    }*/

    @Override
    public void show(C C) {
        System.out.println("B and C");
    }
}

class C extends B {
    @Override
    public void show(A a) {
        System.out.println("C and A");
    }

    /*@Override
    public void show(B b) {
        System.out.println("C and B");
    }*/

    @Override
    public void show(C C) {
        System.out.println("C and C");
    }
}