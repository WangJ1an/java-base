package com.java.base.regex;

/**
 * Created by 1 on 2017/3/14.
 */
public class RegexDemo {
    public static void main(String[] args) {
/*
* 对QQ号进行校验
* 要求：5-15位数字
* */
        String qq = "784324231";
        boolean b = check(qq);
        boolean b1 = qq.matches("[1-9][0-9]{4,14}");//正则表达式
        System.out.println(qq+" : "+b1);

    }

    public static boolean check(String qq) {
        int len = qq.length();
        boolean flag = false;
        if (len >= 5 && len <= 15) {
            if (!qq.startsWith("0")) {
                try {
                    Long num = Long.parseLong(qq);
                    flag = true;
                } catch (Exception e) {
                    System.out.println("出现非法数字");
                }
            }
        }
        return flag;
    }
}
