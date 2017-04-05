package com.java.base.udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by 1 on 2017/3/8.
 */
public class UDPChatTest {
    public static void main(String[] args) throws SocketException {
        DatagramSocket sendSocket = new DatagramSocket();
        DatagramSocket receSocket = new DatagramSocket(10002);
        Send send = new Send(sendSocket);
        Rece rece = new Rece(receSocket);
        Thread thread1 = new Thread(send);
        Thread thread2 = new Thread(rece);
        thread1.start();
        thread2.start();
    }
}
//发送任务线程
class Send implements Runnable{
    private DatagramSocket ds;

    public Send(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = in.readLine()) != null) {
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 10002);
                ds.send(dp);
                if ("over".equals(line)) {
                    break;
                }
            }
            ds.close();
        }catch (IOException e) {

        }
    }
}
//接收任务线程
class Rece implements Runnable{
    private DatagramSocket ds;

    public Rece(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);

                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(), 0, dp.getLength());

                System.out.println(ip + ":" + port + ":" + text);
                if (text.equals("over")) {
                    System.out.println(ip+"用户离开聊天室");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}