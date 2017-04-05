package com.java.base.tcp.uploadpic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 1 on 2017/3/9.
 */
public class UpLoadPicServ {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10004);
        while (true) {
            Socket socket = ss.accept();

            new Thread(new UpLoadPicTask(socket)).start();


        }
    }
}
