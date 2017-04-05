package com.java.base.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 2017/1/20.
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
//        需求：获取目录下所有的内容
        File file = new File("D:\\workspace\\java-base\\src\\com\\java\\base");
        File[] files = file.listFiles();
//        健壮性判断：1。必须是存在的 2。必须是目录。否则容易返回数组为null，会引发NullPointException；
        if (!file.isDirectory() || !file.exists()) {
            throw new NullPointerException("该目录不存在");
        } else {
            for (File f : files) {
                if (f.isDirectory())
                    System.out.println(f.getName() + "------Directory");
                else
                    System.out.println(f.getName() + "------Flie");
            }
        }
    }
}
