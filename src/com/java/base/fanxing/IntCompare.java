package com.java.base.fanxing;

/**
 * Created by 1 on 2017/1/20.
 */
public class IntCompare implements Compare<Integer> {

    @Override
    public boolean compare(Integer obj1, Integer obj2) {
        return obj1 - obj2 < 0 ? false:true;
    }
}
