package com.java.base.tcp.uploadtext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 1 on 2017/3/9.
 */
public class UpLoadTextServer {
    public static void main(String[] args) throws IOException {
        System.out.println("上传文本服务端运行");
        ServerSocket ss = new ServerSocket(10004);
        while (true) {
            Socket socket = ss.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(new FileWriter("sever.txt"), true);
            String line = null;
            while ((line = in.readLine()) != null) {
                pw.println(line);
            }
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("上传成功");
            pw.close();
            socket.close();
        }
    }
}
