package fuxi.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.*;

/**
 * Created by 1 on 2017/8/3.
 */
public class Server {
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void listen() {
        Socket socket = null;
        while (true) {
            try {
                socket = serverSocket.accept();
                new Thread(new ServiceServer(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class ServiceServer implements Runnable {
        private Socket socket;

        public ServiceServer(Socket socket) throws IOException {
            this.socket = socket;
        }

        public void run() {
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;

            try {
                bis = new BufferedInputStream(socket.getInputStream());
                bos = new BufferedOutputStream(socket.getOutputStream());
                byte[] buffer = new byte[1024];
                while (bis.read(buffer) != -1) {
                    String str = new String(buffer);
                    System.out.println(str);
                    if (str.trim().equals("over")) {
                        System.out.println(socket.getInetAddress()+"客户端断开");
                        break;
                    }
                    bos.write("我已收到\r\n".getBytes());
                    bos.flush();
                }

            } catch (IOException e) {

            } finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                    if (bos != null) {
                        bos.close();
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(8899);
        server.listen();
    }
}
