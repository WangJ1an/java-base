package com.java.base.file.filesplit;

import java.io.*;
import java.util.*;

/**
 * Created by 1 on 2017/3/30.
 */
public class MergeFileTest {

    public static void main(String[] args) throws Exception {
        /*
        * 思路：
        * 1，碎片文件有很多，每一个碎片都需要和读取流关联。
        * 2，每一个读取流读到的数据都需要通过一个输出流写入到一个文件中。
        * 3，原理：多个源--->一个目的地。
        *
        * */
        File partsDir = new File("D:\\PartFiles");
        mergeFile(partsDir);

    }

    public static void mergeFile(File partsDir) throws Exception {
        //1.获取配置文件。
        File configFile = getConfigFile(partsDir);
        //2.获取配置信息。
        Properties properties = getProperties(configFile);

        merge(partsDir,properties);

    }

    private static Properties getProperties(File configFile) throws IOException {

        FileInputStream fis = null;
        Properties prop = new Properties();
        try {
            fis = new FileInputStream(configFile);
            prop.load(fis);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return prop;
    }

    private static void merge(File partsDir, Properties properties) throws IOException {

        //获取属性集中的信息
        String filename = properties.getProperty("filename");
        int partCount = Integer.parseInt(properties.getProperty("partcount"));

        //使用io包中的SequenceInputStream，对碎片文件进行合并，将多个读取流合并成一个读取流。
        List<FileInputStream> list = new ArrayList<>();

        for (int i = 1; i < partCount; i++) {
            list.add(new FileInputStream(new File(partsDir,i+".part")));
        }

        //获取enumeration对象
        Enumeration<FileInputStream> en = Collections.enumeration(list);
        //源
        SequenceInputStream sis = new SequenceInputStream(en);
        //目的
        FileOutputStream fos = new FileOutputStream(new File(partsDir,filename));

        //不断的读写
        byte[] buf = new byte[1024*1024];
        int len = 0;
        while ((len = sis.read(buf)) != -1) {
            fos.write(buf,0,len);
        }
    }

    public static File getConfigFile(File partsDir) {

        if (!(partsDir.exists() && partsDir.isDirectory())) {
            throw new RuntimeException("该目录不存在或不是一个目录");
        }

        //1.判断碎片文件目录中是否存在Properties文件
        File[] files = partsDir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".properties");
            }
        });

        if (files.length != 1) {
            throw new RuntimeException("properties扩展名文件不存在，或不唯一");
        }

        File configFile = files[0];
        return configFile;
    }
}
