package com.java.base.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by 1 on 2017/3/8.
 */
public class UDPSend2 {
    public static void main(String[] args) throws SocketException {
        DatagramSocket ds = new DatagramSocket(9999);
        while (true) {
            try {
                BufferedReader buffin = new BufferedReader(new InputStreamReader(System.in));
                String line = null;
                while ((line = buffin.readLine()) != null) {
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
                ds.close();
            }
        }
    }
}
