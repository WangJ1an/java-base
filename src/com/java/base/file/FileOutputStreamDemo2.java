package com.java.base.file;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by 1 on 2017/3/7.
 */
public class FileOutputStreamDemo2 {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\workspace\\java-base\\src\\com\\java\\base\\file\\test.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        String str = LINE_SEPARATOR+"java";
        fos.write(str.getBytes());
        fos.close();
    }
}
