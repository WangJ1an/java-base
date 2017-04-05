package com.java.base.file.filesplit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by 1 on 2017/3/30.
 */
public class ReaderPartConfigDemo {

    public static void main(String[] args) throws Exception {
        File config = new File("D:\\PartFiles\\6.partconfig");
        readPartConfig(config);
    }

    public static void readPartConfig (File config) throws Exception {
        BufferedReader bufr = new BufferedReader(new FileReader(config));

        String line = null;
        while ((line = bufr.readLine()) != null) {
            String[] arr = line.split("=");
            System.out.println(arr[0]+"::::"+arr[1]);
        }

        /*
        * 发现配置文件的信息很多，需要进行存储。
        * 用哪个容器呢？个数不确定，就使用集合。
        * 发现信息中存在对应关系，使用Map集合。
        * 发现一点，配置文件中的信息都是字符串，这些信息不在内存中，而是在硬盘上。
        * map中和io技术结合的集合对象：Properties，
        * 里面存储的键值
        */
        bufr.close();
    }
}
