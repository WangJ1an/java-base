package com.java.base.tcp;

import java.io.*;
import java.net.*; 

public class MyServer {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(9090);
        System.out.println(server.getInetAddress());
        Socket socket = server.accept();
        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String text = new String(buf,0,buf.length);

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("欢迎光临");

        socket.close();
        server.close();
    }
} 
