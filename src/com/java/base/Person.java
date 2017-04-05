package com.java.base;

import com.java.base.sort.Compare;

/**
 * Created by 1 on 2017/2/21.
 */
public class Person implements Compare<Person>,Comparable<Person> {
    private String name;
    private int age;

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(String name,int age) {
        System.out.println("show...run:  "+name+"....."+age);
    }

    public Person(){}
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Person))
            throw new ClassCastException("类型错误");
        Person p = (Person)obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

    @Override
    public int compare(Person p1, Person p2) {
        return  p1.age - p2.age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(Person o) {
        int temp = this.age - o.age;
        return temp == 0 ? this.getName().compareTo(o.getName()) : temp;
    }
}
