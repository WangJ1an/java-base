package com.java.base.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1 on 2017/4/2.
 */
public class MachesDemo {
    //1.匹配
    public static void function1() {
        String number = "18302986656";
        String number_regex = "1[358]\\d{9}";
        System.out.println(number+" : "+number.matches(number_regex));
    }

    //2.切割
    public static void function2() {
        //按照叠词切割,后者复用前者的内容
        //必须在正则表达式中进行复用：将需要复用的内容进行封装，然后调用这个封装即可
        //正则的复用是用小括号（）来封装的，虽然没有名字，但是
        //正则在使用（）进行封装时，自动的给这些小括号进行了编号
        //从1开始，称之为正则表达式中的组。通过组的编号就可以调用指定的组，进行复用。
        String str = "dadefea##dcxvKKKKiop";
        String regex = "(.)\\1+";

        //(A)(B)(C)(D)\\1\\3\\2\\4  ABCDACBD
        //((A)(B(C)))  1:((A)(B(C))) 2:(A) 3:(B(C)) 4:(C)  组嵌套：技巧：从左起数有几个左括号就是几组

        String[] strs = str.split(regex);
        for (String s :
                strs) {
            System.out.println(s);
        }
    }

    //3.替换
    public static void function3() {
//        String str = "qwe###wrrrrrrqsa######gdre";
//        将#替换为@
//        str = str.replaceAll("#+","@");

//        String str = "qwe###wrrqsa######gdre";
//        将叠词替换为@
//        str = str.replaceAll("(.)\\1+","@");

//        String str = "qwe###wrrrrrqsssssa######gdre";
//        将叠词替换为其中的一个，如多个%%%%替换为%，多个###替换为#
//        str = str.replaceAll("(.)\\1+","$1");
//        当在第二个参数中使用第一个正则参数中的组时，可以通过使用 $编号 来完成组的调用。
//        \\1只能使用在正则表达式中

//        String str = "qweage:20rewrw188023eafgs890988gfs";
//        将论坛帖子的联系方式数字都替换***
//        str = str.replaceAll("\\d{5,}","***");

        String str = "18300001111";
        str = str.replaceAll("(\\d{3})(\\d{4})(\\d{4})","$1****$3");

        System.out.println(str);
    }

    //4,获取
    public static void function4() {
        String str = "da jia zhu yi la, ming tian fang jia le!";
        String regex = "\\b[a-zA-Z]{3}\\b";//取出由3个字母组成的单词

        //1.获取正则表达式对象
        Pattern p = Pattern.compile(regex);

        //2.和要操作的字符串关联，获取对应的匹配器对象
        Matcher m = p.matcher(str);

        while (m.find()) {
            System.out.println(m.group());
        }
    }

    public static void main(String[] args) {
      function4();
    }
}
