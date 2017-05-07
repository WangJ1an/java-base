package com.java.base.tcp.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 1 on 2017/4/23.
 */
public class MyServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("MyServer is run: ");
        Socket socket = null;
        while (true) {
            try {
                socket = serverSocket.accept();

//                System.out.println(socket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }

                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                out.println("<font color='red' size='7'>欢迎光临</font>");
            } finally {
                socket.close();
            }
        }
    }
}
