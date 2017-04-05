package com.java.base.practice;

import java.io.*;
import java.util.Date;

/**
 * Created by 1 on 2017/3/5.
 */
public class IOTest {
    void testFile() {
        File file = new File("iotest");
        try {
            file.createNewFile();
            System.out.println(file.getPath());
            System.out.println(file.getName());
            System.out.println(file.isFile());
            System.out.println(file.isDirectory());
            System.out.println(file.setWritable(true));
            System.out.println(file.setReadable(true));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void testFileIO() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("iotest"));
        char[] writeChars = new char[]{'1','2','3'};
        out.write(writeChars);
        out.write("abc",0,3);
        out.flush();
        out.close();

        BufferedReader in = new BufferedReader(new FileReader("iotest"));
        StringBuilder outputstr = new StringBuilder(10);

        char[] readBuf = new char[10];
        int readLen = in.read(readBuf,0,readBuf.length);
        if (readLen != -1) {
            outputstr.append(readBuf,0,readLen);
            readLen = in.read(readBuf,0,readLen);
        }
        System.out.println(readBuf);
        System.out.println(outputstr.toString());
        in.close();
    }

    void testFileStream() {
        try {
            FileOutputStream fos = new FileOutputStream("t.tmp");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            String str = "hello java";
            bos.write(str.getBytes());
            bos.close();

            FileInputStream fis = new FileInputStream("t.tmp");
            BufferedInputStream bis = new BufferedInputStream(fis);
            StringBuilder outputstr = new StringBuilder(10);
            byte[] readBytes = new byte[100];
            int readLen = bis.read(readBytes, 0, readBytes.length);
            while (readLen != -1) {
                outputstr.append(new String(readBytes, 0, readLen));
                readLen = bis.read(readBytes, 0, readLen);
            }
            bis.close();
            System.out.println(outputstr.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void testObjectStream() throws IOException {
        File f = new File("ioobject");
        f.createNewFile();
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeInt(12345);
        oos.writeObject("Today");

        oos.writeObject(new Date());
        oos.close();

        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        int i = ois.readInt();
        String today = null;
        Date date = null;
        try {
            today = (String)ois.readObject();
            date = (Date) ois.readObject();
        } catch (ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
        System.out.println(i);
        System.out.println(today);
        System.out.println(date.toString());
    }

    public static void main(String[] args) throws IOException {
        new IOTest().testObjectStream();
    }
}
