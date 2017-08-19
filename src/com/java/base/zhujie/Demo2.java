package com.java.base.zhujie;

/**
 * Created by 1 on 2017/8/7.
 */
@MyAnno2_1(age = 100, name = "zhangsan")
public class Demo2 {

}

@interface MyAnno2_1 {
    int age() default 0;
    String name();

}

@MyAnno2_2(100)
@interface MyAnno2_2 {
    int value();
    String name() default "wangwu";
}
