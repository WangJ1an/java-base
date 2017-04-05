
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/*
 * see README.md
 */
public class EchoClientV1 {

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

    public static void main(String[] args) throws IOException {
        String serverAddress = null;
        int port = 9090;
        if (args.length == 3) {
            serverAddress = args[1];
            port = Integer.valueOf(args[2]);
        }
        System.out.println(String.format("connect to %s %d", serverAddress, port));
        //create client Socket and connect to serverAddress:port.
        Socket s = new Socket(serverAddress, port);
        while (true) {
            try {
                System.out.println("\nPlease input you request: ");
                //create inputstream buffer, buffered stdin
                BufferedInputStream in = new BufferedInputStream(System.in);
                StringBuilder writeStr = new StringBuilder(10);
                writeStr.append(EchoClientV1.readLine(in));
                System.out.println(String.format("write request server: %s", writeStr.toString()));

                //create outputstream buffer, buffered socket write
                BufferedOutputStream out = new BufferedOutputStream(s.getOutputStream());
                //write writeStr to socket
                out.write(writeStr.append("\n").toString().getBytes());
                //flush the buffer bytes,  send buffered bytes to remote socket
                out.flush();

                System.out.println("wait for server response...");
                StringBuilder serverRes = new StringBuilder(10);
                //create intputstream buffer, buffered socket read
                BufferedInputStream outBuf = new BufferedInputStream(s.getInputStream());
                serverRes.append(EchoClientV1.readLine(outBuf));
                System.out.println(String.format("read server response : %s", serverRes));
            } catch (Exception e) {
                s.close();
            }
        }
    }
}
