package com.java.base.file.properties;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 * Created by 1 on 2017/3/30.
 */
public class PropertiesDemo {
    public static void main(String[] args) throws Exception {
//        methodDemo_1();
//        methodDemo_2();
        methodDemo_3();
    }

    //演示保存到流中的方法（持久化）。
    public static void methodDemo_3() throws Exception {
        Properties prop = new Properties();

        prop.setProperty("张三","19");
        prop.setProperty("李四","23");

        FileWriter fw = new FileWriter("info.properties");

        prop.store(fw,"info");

        fw.close();

    }

    //演示从流中加载。
    public static void methodDemo_2() throws Exception {

        File configFile = new File("D:\\PartFiles\\6.partconfig");
        FileReader fr = new FileReader(configFile);

        Properties prop = new Properties();

        prop.load(fr);

        System.out.println(prop);

        fr.close();
    }

    //1.基本使用，存和取
    public static void methodDemo_1() {

        //创建一个Properties集合
        Properties prop = new Properties();

        //添加数据
        prop.setProperty("张三","19");
        prop.setProperty("李四","23");
//        获取数据，一个。
//        String value = prop.getProperty("张三");
//        System.out.println(value);

        //全部取出。
//        Set<String> set = prop.stringPropertyNames();
//
//        for (String name : set) {
//            String value = prop.getProperty(name);
//            System.out.println(name+" : "+value);
//        }
//        prop.list(System.out);



    }
}
