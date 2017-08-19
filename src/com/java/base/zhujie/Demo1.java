package com.java.base.zhujie;

/**
 * Created by 1 on 2017/8/6.
 */
@MyAnno1
public class Demo1 {
    @MyAnno1
    private String name;

    @MyAnno1
    public Demo1() {}

    @MyAnno1
    public void fun1() {

    }

    public void fun2(@MyAnno1 String name) {
        @MyAnno1
        String username ="hello";
    }
}

@interface MyAnno1{

}
