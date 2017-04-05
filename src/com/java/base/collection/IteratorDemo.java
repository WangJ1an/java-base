package com.java.base.collection;

import java.util.*;

/**
 * Created by 1 on 2017/2/27.
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        ListIterator li = list.listIterator();
        while (li.hasNext()) {
            Object obj = li.next();
            if ("abc2".equals(obj))
                li.set("java");
        }
        System.out.println(list);
    }
}