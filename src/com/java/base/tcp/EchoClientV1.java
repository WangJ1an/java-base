package com.java.base.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * Trivial client for the date server.
 */
public class EchoClientV1 {

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
            port = Integer.valueOf(args[2]);
        }
        System.out.println(String.format("connect to %s %d", serverAddress, port));
        Socket s = new Socket(serverAddress, port);
        BufferedInputStream in = new BufferedInputStream(s.getInputStream());
        int read = in.read();
        if (read != -1) {
            byte[] readBytes = new byte[read];
            in.read(readBytes);
            System.out.println(String.format( new String(readBytes)));
        }
        while (true) {
            try {
                System.out.println("please input you command: ");
                BufferedInputStream cmdBuf = new BufferedInputStream(System.in);
                byte[] writeBytes = new byte[10];
                cmdBuf.read(writeBytes);
                System.out.println(String.format("write %s to server", new String(writeBytes)));

                BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream(), 120);
                out.write(writeBytes);
                out.flush();

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
