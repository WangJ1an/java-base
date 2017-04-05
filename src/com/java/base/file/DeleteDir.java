package com.java.base.file;

import java.io.File;

/**
 * Created by 1 on 2017/3/10.
 */
public class DeleteDir {
    //删除一个带有内容的目录，必须从里往外删
    //递归
    public static void main(String[] args) {
        File dir = new File("D:\\我是目录");
        removeDir(dir);
    }

    public static void removeDir(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                removeDir(f);  //是目录，递归
            } else {
                System.out.println("File : "+f.getName()+" ------delete "+f.delete());  //不是目录，删除
            }
        }
//        递归完毕后目录为空，删除目录。
        System.out.println("Directory : "+file.getName()+" ------delete "+file.delete());  //不是目录，删除
    }
}
