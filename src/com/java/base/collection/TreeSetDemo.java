package com.java.base.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 1 on 2017/2/27.
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int temp = str1.length() - str2.length();
                return temp == 0 ? str1.compareTo(str2) : temp ;
            }
        });
        set.add("haha");
        set.add("java");
        set.add("hiahia");
        set.add("z");
        set.add("abc");
        for (String str : set) {
            System.out.println(str);
        }
        String[] str = set.toArray(new String[5]);
    }
}
