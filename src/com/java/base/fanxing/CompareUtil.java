package com.java.base.fanxing;

/**
 * Created by 1 on 2017/1/20.
 */
public class CompareUtil {
    public static<T> boolean compare(T obj1,T obj2,Compare compare){
        return compare.compare(obj1,obj2);
    }
}
