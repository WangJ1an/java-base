package com.java.base.file;

import java.io.File;

/**
 * Created by 1 on 2017/3/7.
 */
public class GetAllFiles {
    public static void main(String[] args) {
        File file = new File("D:\\workspace\\java-base\\src\\com\\java\\base");
        diGuiDir(file);
    }

    static void diGuiDir(File dir) {
        System.out.println("dir: "+dir.getName());
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                diGuiDir(f);
            } else {
                System.out.println("flie: "+f.getName());
            }
        }
    }
}
