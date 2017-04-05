package com.java.base.udp;

import java.io.*;
import java.net.*;

/**
 * Created by 1 on 2017/3/8.
 */
public class UDPSend {
    public static void main(String[] args) throws SocketException {
        /*
        * 通过查阅文档，了解到用于udp传输协议的对象是DatagramSocket。
        *
        * 通过udp的协议发送一段文本数据。
        * 思路：
        * 1.需要先建立udp的socket。它具备着发送或接受功能。
        * 2.将数据封装到数据包中。数据包对象是DatagramPacket。
        * 3。使用socket对象的send方法将数据包发送出去。
        * 4.关闭资源
        * */
        DatagramSocket ds = new DatagramSocket(8888);
        while (true) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while ((line = in.readLine()) != null) {
                    if ("over".equals(line)){
                        break;
                    }
                    byte[] buf = line.getBytes();
                    DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 10000);
                    ds.send(dp);
                }
                ds.close();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
