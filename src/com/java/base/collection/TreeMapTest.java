package com.java.base.collection;

import com.java.base.Student;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 1 on 2017/3/6.
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<Student,String> map = new TreeMap<Student,String>();
        map.put(new Student("小明",19),"宁夏");
        map.put(new Student("李嘉威",26),"西安");
        map.put(new Student("王键",20),"汉中");
        for (Map.Entry<Student,String> me : map.entrySet()) {
            System.out.println(me);
        }
    }
}
