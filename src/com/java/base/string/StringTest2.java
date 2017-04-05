package com.java.base.string;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * Created by 1 on 2017/2/25.
 */
public class StringTest2 {
    /*
    *对字符串中字符进行自然顺序排序
    * "cfdasbv"---->"abcdsv"
     */
    public static void main(String[] args) {
        String str = "cfdasbv";
        System.out.println(sortString(str));
    }

    public static String sortString(String str) {
        char[] c = str.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}

