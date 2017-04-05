package com.java.base.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by 1 on 2017/3/9.
 */
public class TransClient {
    public static void main(String[] args) throws IOException {
//        1.创建socket，明确地址和端口。
        Socket socket = new Socket(InetAddress.getLocalHost(),10003);
        while (true) {
//        2.源：键盘录入。获取需要转换的工具。
            BufferedReader brf = new BufferedReader(new InputStreamReader(System.in));
//        3.目的：网络，socket输出流。将录入的数据发送到服务器。
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
//        4.源：socket，socket读取流。读取服务端发送回来的大写数据。
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        5.目的：客户端显示器，将大写数据显示出来。
//        6.频繁的读写操作。
            String line = null;
            while ((line = brf.readLine()) != null) {
                out.println(line);
                if ("over".equals(line)) {
                    break;
                }
                System.out.println("接收服务器返回的： ");
                System.out.println(in.readLine());
            }
            socket.close();
        }
//        7.关闭资源。
    }
}
