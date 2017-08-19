package com.java.base.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1. 错误处理
 * 2. 内存分配
 * 3. 服务模型 多线程
 * 4. 演示多于线程池的连接时, 后续请求阻塞
 * 5. 问题: 如果非常多的客户端同时连接进来, 如何解决?
 */
public class EchoServerV2 {

    private ExecutorService ecs;
    private List<Socket> sockets;
    private ServerSocket listener;

    public EchoServerV2(int nThreads) {
        this.ecs = Executors.newFixedThreadPool(nThreads);
        this.sockets = new ArrayList<Socket>(1);
    }

    public void start() {
        try {
            this.listener = new ServerSocket(9090);
            if (this.listener != null) {
                System.out.println(String.format("listen at %s %s", listener.getInetAddress().getHostName(), listener.getLocalPort()));
                Socket socket = null;
                while(true) {
                    socket = this.listener.accept();
                    System.out.println("accept client connect");
                    this.sockets.add(socket);
//                    ecs.submit(new processTask(socket));
                    ecs.execute(new processTask(socket));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.listener.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int countConnection() {
        return sockets.size();
    }

    private class processTask implements Runnable {
        private Socket socket;

        public processTask(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            System.out.println(String.format("receive the %d client with ThreadDemo id %d",
                        sockets.size(), Thread.currentThread().getId()));
            while (true) {
                boolean error = false;
                try {
                    BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
                    int readLen = in.read();
                    if (readLen != -1) {
                        System.out.println(String.format("read len %d", readLen));
                        byte[] bytes = new byte[readLen];
                        in.read(bytes);
                        System.out.println(String.format("read client request %s", new String(bytes)));
                    } else {
                        if (this.socket.isClosed()
                                || this.socket.isInputShutdown()
                                || this.socket.isOutputShutdown()) {
                            sockets.remove(socket);
                            break;
                        }
                    }

                    System.out.println("write response to client");
                    for (Socket s : sockets) {
                        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                        String outStr = new Date().toString();
                        System.out.println(String.format("write response %s to client", outStr));
                        out.write(outStr.getBytes());
                        out.flush();
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                    error = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    error = true;
                }
                if (error) {
                    if (this.socket != null) {
                        sockets.remove(socket);
                    }
                    if (!this.socket.isClosed()) {
                        try {
                            this.socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }
        }
    }

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        EchoServerV2 es = new EchoServerV2(3);
        es.start();
    }
}
