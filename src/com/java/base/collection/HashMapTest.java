package com.java.base.collection;

import com.java.base.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 1 on 2017/3/6.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Student,String> map = new HashMap<Student,String>();
        map.put(new Student("小明",19),"宁夏");
        map.put(new Student("李嘉威",20),"西安");
        map.put(new Student("王键",20),"汉中");
        map.put(new Student("王键",20),"shanxi");//保证键的唯一性
        Set<Student> set = map.keySet();
        for (Student key : set) {
            String value = map.get(key);
            System.out.println(key+"--------"+value);
        }
    }
}