
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
public class EchoClientV3 {

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
        int port = 9091;
        if (args.length == 3) {
            serverAddress = args[1];
            port = getPort(args[2]);
        }
        System.out.println(String.format("connect to %s %d", serverAddress, port));
        Socket s = new Socket(serverAddress, port);
        while (true) {
            try {
                BufferedReader reqBuf = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String reqStr = reqBuf.readLine();
                while (reqStr == null) {
                    reqStr = reqBuf.readLine();
                }
                System.out.println(String.format("read request from other client: %s", reqStr));
            } catch (Exception e) {
                s.close();
            }
        }
    }
}
