package com.java.base.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 1 on 2017/3/7.
 */
public class FileIOException {
    public static void main(String[] args) {
        File file = new File("D`:\\workspace\\java-base\\src\\com\\java\\base\\file\\test.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write("hahaha".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) { //判断，如果fos为空就不需要关闭，不为空时才能关闭。
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException("");
                }
            }
        }
    }
}
