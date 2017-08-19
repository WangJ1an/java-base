package com.java.base.zhujie;

/**
 * Created by 1 on 2017/8/7.
 */
@MyAnno3_1(
        a = 100,
        b = "hello",
        c = MyEnum.A,
        d = String.class,
        e = @MyAnno3_2(age = 100, name = "zhangsan"),
        f = {"hehe","haha"}
)
public class Demo3 {
}

@interface MyAnno3_1 {
    int a();
    String b();
    MyEnum c();
    Class d();
    MyAnno3_2 e();
    String[] f();
}

@interface MyAnno3_2 {
    int age();
    String name();
}

enum MyEnum {
    A,B,C
}
