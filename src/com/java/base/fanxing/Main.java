package com.java.base.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/1/20.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(3);
        list.add(4);
        list.add(1);
        int max = FindMaxValue.findMaxValue(list,new IntCompare());
        System.out.println(max);
    }
}
