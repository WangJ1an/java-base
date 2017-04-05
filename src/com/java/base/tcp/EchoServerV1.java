package com.java.base.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.nio.ByteBuffer;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client the current date and time, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class EchoServerV1 {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        System.out.println(String.format("listen at %s %s", listener.getInetAddress().getHostName(), listener.getLocalPort()));
        Socket socket = null;
        try {
            socket = listener.accept();

            BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
            String str = " You're welcome!!!";
            out.write(str.getBytes());
            out.flush();

            while (true) {
                boolean error = false;
                try {
                    int readLen = in.read();
                    if (readLen != -1) {
                        System.out.println(String.format("read len %d", readLen));
                        byte[] bytes = new byte[readLen];
                        in.read(bytes);
                        System.out.println(String.format("read client request %s", new String(bytes)));
                    }

                    System.out.println("write response to client");
                    BufferedInputStream cmdBuf = new BufferedInputStream(System.in);
                    byte[] writeBytes = new byte[10];
                    cmdBuf.read(writeBytes);
                    System.out.println(String.format("write %s to client", new String(writeBytes)));
                    out.write(writeBytes);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                    error = true;
                } finally {
                    if (socket != null && socket.isClosed()) {
                        socket.close();
                    }
                }
                if (error) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            listener.close();
        }
    }
}
