package com.java.base.file;

import java.io.*;

/**
 * Created by 1 on 2017/1/20.
 */
public class ReadFile {
    public static void ReadFileByLine(String fileName){
        BufferedReader reader = null;
        try{
            System.out.println("按行读取文件:");
            reader = new BufferedReader(new FileReader(fileName));
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                System.out.println(tempString);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
