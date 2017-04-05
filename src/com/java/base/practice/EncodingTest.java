package com.java.base.practice;

import java.io.UnsupportedEncodingException;

/**
 * Created by 1 on 2017/3/10.
 */
public class EncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //对字符串编码------>字节数组
        String string = "你好";
        byte[] buf = string.getBytes();
        for (int i = 0; i < buf.length; i++) {
            System.out.println(buf[i]);
        }

        //对字节数组解码----->字符串
        System.out.println(new String(buf));
    }
}
