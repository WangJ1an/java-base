package com.java.base.string;

import com.java.base.Person;

import java.util.Random;

/**
 * Created by 1 on 2017/2/21.
 */
public class PersonDemo {
    public static void main(String []args){
        Person person1 = new Person("张三",20);
        Person person3 = new Person("张三",20);
        Person person2 = new Person("李四",25);
        Random random  = new Random();
        person1.setAge(random.nextInt(80));
        person2.setAge(random.nextInt(80));

        System.out.println(person1.getAge());
        System.out.println(person2.getAge());
        //System.out.println(person1.toString());
        System.out.println(person1.compare(person1,person2));
        //System.out.println(person1.equals(person2));
        //System.out.println(person1.equals(person3));
    }
}
