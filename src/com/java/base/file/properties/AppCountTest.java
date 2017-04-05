package com.java.base.file.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by 1 on 2017/3/31.
 */
public class AppCountTest {

    private static File configFile = new File("D:\\PartFiles\\count.p roperties");
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        if (isStop()) {
            System.out.println("试用次数已到，请注册");
            return;
        }
    }

    private static boolean isStop() throws IOException {
        if (!configFile.exists()) {
            configFile.createNewFile();
        }
        FileInputStream fis = null;
        Properties prop = new Properties();
        try {
            fis = new FileInputStream(configFile);
            prop.load(fis);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        String value = prop.getProperty("count");

        if (value != null) {
            count = Integer.parseInt(value);
            if (count >= 3) {
                return true;
            }
        }

        count++;
        FileOutputStream fos = new FileOutputStream(configFile);

        prop.setProperty("count",String.valueOf(count));

        prop.store(fos,"count");

        fos.close();
        return false;
    }

}
