package com.java.base.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by 1 on 2017/2/26.
 */
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    //获取随机字符串
    public static String getString() {
        String str = "HDAShadkhaKHFJDKfhsfhsdkdFHksjDSLAvihIvhksfFHSFkhfjJDbsKjbFsdFSHFK";
        Random random = new Random();
        String s = null;
        while (true) {
            int start = random.nextInt(50);
            int end = random.nextInt(50);
            if (start < end) {
                s = str.substring(start, end);
            } else if (s != null){
                break;
            }
        }
        return s;
    }
//通过比较名字大小的方式排序
    public static User[] nameSort(User[] users) {
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return users;
    }
//通过比较年龄大小的方式排序
    public static User[] ageSort(User[] users) {
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getAge() > o2.getAge())
                    return 1;
                return -1;
            }
        });
        return users;
    }

    public static void main (String[] args) {
        //建立指定容量为5的UserTest2类型的链表
        ArrayList<User> users = new ArrayList<User>(5);

        Random random = new Random();

        //向链表users中添加对象元素
        for (int i = 0; i < 5; i++) {
            users.add(new User(getString()+"--"+i, random.nextInt(60)));
        }

        User[] newuser = users.toArray(new User[5]);
        //打印排序前数组
        for (User u : newuser) {
            System.out.println("姓名："+u.getName()+"年龄："+u.getAge());
        }

        newuser = nameSort(newuser);
        //newuser = ageSort(newuser);
        System.out.println("排序后-------------->");

        for (User u : newuser) {
            System.out.println("姓名："+u.getName()+"年龄："+u.getAge());
        }
    }
}

