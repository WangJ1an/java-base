package com.java.base.collection;

import com.java.base.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by 1 on 2017/2/27.
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Person("lishi1",20));
        set.add(new Person("lishi2",21));
        set.add(new Person("lishi1",20));
        set.add(new Person("lishi3",21));
        for (Iterator it = set.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }
}
