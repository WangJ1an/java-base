package com.java.base.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 1 on 2017/3/7.
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\workspace\\java-base\\src\\com\\java\\base\\file\\test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        byte[] data = "hahahahahhaha".getBytes();
        fos.write(data);
        //关闭流资源
        fos.close();
    }
}
