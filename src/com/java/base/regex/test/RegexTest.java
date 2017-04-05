package com.java.base.regex.test;

import java.util.Arrays;

/**
 * Created by 1 on 2017/4/2.
 */
public class RegexTest {
    /*
    * 案例一：我我...我我我...我我要要....要要要要学学...学学学软...软软软件件...件件件
    * 实现：我要学软件
    * 思路：
    * 1.使用正则表达式。
    * 2.先把所有的.去掉。替换
    * 3.替换叠词。替换
    */
    public static void test_1() {
        String str = "我我...我我我...我我要要....要要要要学学...学学学软...软软软件件...件件件";

        str = str.replaceAll("\\.+","");
        str = str.replaceAll("(.)\\1+","$1");
        System.out.println(str);
    }

    /*
    * 案例二：
    * "23.12.10.5    192.168.100.223   3.3.3.3   10.10.10.10"
    * 要求将这些ip按照顺序进行排序
    *
    * 思路：
    * 1.将ip通过空格切割。
    * 2.将每一段补足三位，不满足的用0填充，然后比较字典顺序
    * 3.技巧：干脆按照所需的最多的0的个数来补。每一段都补两个0
    *          有的地址段多了，取每一段的最后三位。
    */
    public static void test_2() {
        String ip_str = "23.12.10.5    192.168.100.223   3.3.3.3   10.10.10.10";
        ip_str = ip_str.replaceAll("(\\d+)","00$1");
        ip_str = ip_str.replaceAll("0*(\\d{3})","$1");
        System.out.println(ip_str);

        String[] ips = ip_str.split(" +");
        Arrays.sort(ips);
        for (String ip :
                ips) {
            System.out.println(ip.replaceAll("0*(\\d+)","$1"));
        }
    }

    /*
    * 案例三：对邮件地址进行校验
    *
    */
    public static void test_3() {
        String mail = "itcast2013@itcast.com.cn";

        String regex = "[\\w]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}";
        boolean b = mail.matches(regex);
        System.out.println(b);
    }
    public static void main(String[] args) {
      test_3();
    }
}
