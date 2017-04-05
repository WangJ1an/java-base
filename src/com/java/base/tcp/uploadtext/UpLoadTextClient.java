package com.java.base.tcp.uploadtext;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by 1 on 2017/3/9.
 */
public class UpLoadTextClient {
    public static void main(String[] args) throws IOException {
        System.out.println("上传文件客户端运行");
        Socket socket = new Socket(InetAddress.getLocalHost(),10004);
        BufferedReader brf = new BufferedReader(new FileReader("D:\\workspace\\java-base\\iotest"));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        String line = null;
        while ((line = brf.readLine()) != null) {

            out.println(line);

        }
//        设置服务端结束标记
        socket.shutdownOutput();//向服务端发送了一个标准的结束标记；可以让服务端结束读取的动作
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(in.readLine());
        brf.close();
        socket.close();
    }
}
