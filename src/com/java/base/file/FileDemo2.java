package com.java.base.file;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/**
 * Created by 1 on 2017/3/7.
 */
public class FileDemo2 {
    public static void main(String[] args) {
        File file = new File("D:\\workspace\\java-base\\src\\com\\java\\base");
        File[] files = file.listFiles(new FileFilterByDir());
        for (File f : files) {
            System.out.println(f);
        }
    }
}

class FileNameFilterByJava implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".java");
    }
}

class FileFilterByDir implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}
