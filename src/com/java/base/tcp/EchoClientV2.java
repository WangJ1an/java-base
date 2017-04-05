package com.java.base.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * 问题: 服务端宕机时, 客户端如何检测服务端不可用
 *
 */
public class EchoClientV2 {

    public static int getPort(String port) {
        int iport = Integer.valueOf(port);
        if (iport < 0 || iport > 0xFFFF) {
            throw new IllegalArgumentException("Port out of range:"+ iport);
        }
        return iport;
    }

    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main(String[] args) throws IOException {
        String serverAddress = null;
        int port = 9090;
        if (args.length == 3) {
            serverAddress = args[1];
            port = getPort(args[2]);
        }
        System.out.println(String.format("connect to %s %d", serverAddress, port));
        Socket s = new Socket(serverAddress, port);
        while (true) {
            try {
                System.out.println("please input you command: ");
                BufferedReader cmdBuf = new BufferedReader(new InputStreamReader(System.in));
                String cmdStr = cmdBuf.readLine();
                System.out.println(String.format("write %s to server", cmdStr));

                BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream(), 120);
                out.write(cmdStr.getBytes());
                out.flush();

                BufferedInputStream in = new BufferedInputStream(s.getInputStream());
                int readLen = in.read();
                if (readLen != -1) {
                    byte[] readBytes = new byte[readLen];
                    in.read(readBytes);
                    System.out.println(String.format("read client request %s", new String(readBytes)));
                }
            } catch (Exception e) {
                s.close();
            }
        }
    }
}
