package com.java.base.fanxing;

import com.java.base.Person;
import com.java.base.Student;
import com.java.base.Worker;

import java.util.*;

/**
 * Created by 1 on 2017/3/2.
 */
public class GenericDemo {
    public static void main(String[] args) {
        Collection<Person> c = new ArrayList<Person>();
        c.add(new Student("李四",31));
        c.add(new Worker("小明",28));
        c.add(new Person("小红",25));
        System.out.println(Collections.max(c));
        Person person = getMax(c);
        System.out.println(person);
    }

    public static<T extends Comparable<? super T>> T getMax(Collection<? extends T> c) {
        Iterator<? extends T> it = c.iterator();
        T max = it.next();
        while (it.hasNext()) {
            T temp = it.next();
            if (temp.compareTo(max) > 0) {
                max = temp;
            }
        }
        return max;
    }
}
