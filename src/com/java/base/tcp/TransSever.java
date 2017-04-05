package com.java.base.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 1 on 2017/3/9.
 */
public class TransSever {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);
        while (true) {
            Socket socket = ss.accept();
            System.out.println("ip---"+ socket.getInetAddress().getHostAddress()+"connect.....");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            String line = null;
            while ((line = in.readLine()) != null) {
                if ("over".equals(line)) {
                    break;
                }
                System.out.println("来自客户端的消息："+line);
                out.println(line.toUpperCase());
            }
            socket.close();
        }
    }
}
