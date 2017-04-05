package com.java.base.reflect;

import com.java.base.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 1 on 2017/3/13.
 */
public class Reflect_GetClass {
    public static void main(String[] args) throws Exception {
        Person person = new Person("张三",20);

        String className = "com.java.base.Person";

        Class clazz = Class.forName(className);
//        Class clazz = person.getClass();

        Constructor con = clazz.getConstructor(String.class,int.class);

        Object obj = con.newInstance("haha",21);

        String methodName = "show";
        Method show = clazz.getMethod(methodName,String.class,int.class);
        show.invoke(obj,"hehe",18);

        String filedName = "age";
//        Field field = clazz.getField(filedName);    获取的是公共字段
        Field field = clazz.getDeclaredField(filedName);
//        getXXX  获取的都是类中公有的成员
//        getDeclaredXXX  获取本类中已有的成员

        field.setAccessible(true);//取消权限检查，暴力访问
        field.set(obj,80 );//IllegalAccessException（无效访问异常）：  age字段私有

//        Object obj = clazz.newInstance();

        System.out.println(clazz);
        System.out.println(obj);
        System.out.println(field);
    }
}
