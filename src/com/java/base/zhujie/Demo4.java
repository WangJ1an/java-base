package com.java.base.zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 1 on 2017/8/7.
 */
//@MyAnno4_1  错误
public class Demo4 {
    @MyAnno4_1
    public void fun() {

    }
}

@Target({ElementType.METHOD})
@interface MyAnno4_1 {

}

@Retention(RetentionPolicy.RUNTIME)
@interface MYAnno4_2 {

}