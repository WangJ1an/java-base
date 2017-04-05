package com.java.base.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 1 on 2017/1/20.
 */
public class WriteFile {
    public static void appendMethodB(String fileName,String content){
        FileWriter writer = null;
        try{
            writer = new FileWriter(fileName,true);
            writer.write(content);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "D:\\java\\filename.txt";
        appendMethodB(fileName,"append");
        ReadFile.ReadFileByLine(fileName);
    }
}
