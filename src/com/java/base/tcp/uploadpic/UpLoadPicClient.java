package com.java.base.tcp.uploadpic;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by 1 on 2017/3/9.
 */
public class UpLoadPicClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),10004);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("190256-106.jpg"));
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = bis.read(buf)) != -1) {
            out.write(buf,0,len);
        }
        socket.shutdownOutput();
        InputStream in = socket.getInputStream();
        byte[] bufIn = new byte[1024];
        int lenin = in.read(bufIn);
        System.out.println(new String(bufIn,0,lenin));
        socket.close();
    }
}
