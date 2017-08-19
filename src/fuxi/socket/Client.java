package fuxi.socket;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by 1 on 2017/8/3.
 */
public class Client {
    private Socket socket = null;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        BufferedReader br = null;
        PrintWriter pw = null;
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in));
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            String readLen = null;
            while ((readLen = clientIn.readLine()) != null) {
                pw.println(readLen);
                pw.flush();
                if (readLen.equals("over")) {
                    break;
                }
                String str = null;
                if ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
            }

        } catch (Exception e) {

        } finally {
            br.close();
            pw.close();
            clientIn.close();
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8899);
        Client client = new Client(socket);
        client.start();
    }
}
