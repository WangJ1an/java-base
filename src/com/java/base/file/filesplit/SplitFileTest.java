package com.java.base.file.filesplit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by 1 on 2017/3/30.
 */
public class SplitFileTest {
    private static final int BUFFER_SIZE = 1024*1024;
    private static final String LINE_SPARATOR = System.getProperty("line.separator");
//    练习：将一个媒体文件切割成多个碎片
    /*
    * 思路：
    * 1.读取源文件，将源文件的数据分别复制到多个文件中
    * 2.切割方式有两种：按照碎片个数切割，或者按照指定大小切割
    * 3.一个输入流对应多个输出流
    * 4.每一个碎片都需要编号，顺序不要出错
    * */

    public static void main(String[] args) throws Exception {
        File srcFile = new File("D:\\workspace\\java-base\\陈奕迅 - 不要说话.mp3");
        File partsDir = new File("D:\\PartFiles");
        splitFile(srcFile,partsDir);
    }

    public static void splitFile(File srcFile, File partsDir) throws Exception {

        //健壮性判断
        if (!(srcFile.exists() && srcFile.isFile())) {
            throw new RuntimeException("源文件不是文件或不存在");
        }

        if (!partsDir.exists()) {
            partsDir.mkdirs();
        }

        //1,使用字节读取流和源文件关联
        FileInputStream fis = new FileInputStream(srcFile);

        //2.明确目的，目的输出流有多个，只创建引用
        FileOutputStream fos = null;

        //3.定义缓冲区，1M
        byte[] buf = new byte[BUFFER_SIZE];

        int len = 0;
        int count = 1;
        while ((len = fis.read(buf)) != -1) {
            //创建输出流对象，只要满足了缓冲区大小，碎片数据确定，直接往碎片文件中写数据
            fos = new FileOutputStream(new File(partsDir,(count++)+".part"));

            fos.write(buf,0,len);

            fos.close();
        }

        /*
        * 将源文件以及切割的一些信息也保存下来随着碎片文件一起发送
        * 信息：
        * 1，源文件的名称（文件类型）
        * 2，切割的碎片个数
        * 将这些信息单独封装到一个文件中
        * 还需要一个输出流完成此动作
        */
        String filename = srcFile.getName();
        int partcount = count;
        fos = new FileOutputStream(new File(partsDir,count+".properties"));
        Properties prop = new Properties();

        prop.setProperty("filename",srcFile.getName());
        prop.setProperty("partcount",Integer.toString(count));

        prop.store(fos,"part info");

//        fos.write(("filename="+filename+ LINE_SPARATOR).getBytes());
//        fos.write(("partcount="+Integer.toString(partcount)).getBytes());

        fos.close();
        fis.close();
    }
}
