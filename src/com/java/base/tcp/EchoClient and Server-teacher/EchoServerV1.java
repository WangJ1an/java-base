
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.nio.ByteBuffer;

/**
 * see README.md
 */
public class EchoServerV1 {

    /*
     * read one line from buffer stream
     */
    static String readLine(BufferedInputStream in) throws IOException {
        StringBuilder strBuf = new StringBuilder(10);
        byte[] byteBuf = new byte[20];
        //read stdin to writeBytes terminated by "\n"
        int len = in.read(byteBuf, 0, byteBuf.length);
        while(len > 0) {
            String tmpStr = new String(byteBuf, 0, len);
            int terminateIndex = tmpStr.indexOf("\n");
            if (terminateIndex != -1) {
                strBuf.append(tmpStr.substring(0, terminateIndex));
                break;
            }
            strBuf.append(tmpStr);
            len = in.read(byteBuf, 0, byteBuf.length);
        }
        return strBuf.toString();
    }

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        //create server socket, and listen at port of 9090
        ServerSocket listener = new ServerSocket(9090);
        System.out.println(String.format("listen at %s %s", listener.getInetAddress().getHostName(), listener.getLocalPort()));
        Socket socket = null;
        try {
            //accept client connection, and creae Socket to process client connect
            socket = listener.accept();
            while (true) {
                boolean error = false;
                try {
                    StringBuilder clientReq = new StringBuilder(10);
                    BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
                    System.out.println(String.format("\nread client request : %s", EchoServerV1.readLine(in)));

                    System.out.println("Please input the response to client: ");
                    StringBuilder resStr = new StringBuilder();
                    //create inputstream buffer, buffered stdin
                    BufferedInputStream resBuf = new BufferedInputStream(System.in);
                    resStr.append(EchoServerV1.readLine(resBuf));
                    System.out.println(String.format("write response to client: %s", resStr.toString()));

                    //create outputstream buffer, buffered socket write
                    BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                    /*
                     * String outStr = new Date().toString();
                     * out.write(outStr.getBytes());
                     */
                    out.write(resStr.append("\n").toString().getBytes());
                    //flush the buffer bytes,  send buffered bytes to remote socket
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
