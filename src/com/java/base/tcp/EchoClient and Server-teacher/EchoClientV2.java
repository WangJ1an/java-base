
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;

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
     */
    public static void main(String[] args) throws IOException {
        String serverAddress = null;
        int port = 9091;
        if (args.length == 3) {
            serverAddress = args[1];
            port = getPort(args[2]);
        }
        System.out.println(String.format("connect to %s %d", serverAddress, port));
        Socket s = new Socket(serverAddress, port);
        while (true) {
            try {
                System.out.println("please input you request: ");
                BufferedReader reqBuf = new BufferedReader(new InputStreamReader(System.in));
                String cmdStr = reqBuf.readLine();
                System.out.println(String.format("write request to server: %s", cmdStr));

                BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream(), 120);
                out.write((cmdStr+"\n").getBytes());
                out.flush();
            } catch (Exception e) {
                s.close();
            }
        }
    }
}
