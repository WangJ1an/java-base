package com.java.base.reflect.test;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/**
 * Created by 1 on 2017/3/13.
 */
public class NoteBookMain {
    public static void main(String[] args) throws Exception {
        NoteBook book = new NoteBook();
        book.run();
//        book.useUSB(new MouseByUSB());

        File configFile = new File("usb.properties");
        if (!configFile.exists()) {
            configFile.createNewFile();
        }

        //读取配置文件
        FileReader fr = new FileReader(configFile);

        //为了获取键值信息方便，建立properties
        Properties prop = new Properties();
        prop.load(fr);

        for (int x = 1; x <= prop.size(); x++) {
            String className = prop.getProperty("usb"+x);
            //反射
            Class clazz = Class.forName(className);

            USB usb = (USB) clazz.newInstance();

            book.useUSB(usb);
        }
        fr.close();
    }
}
