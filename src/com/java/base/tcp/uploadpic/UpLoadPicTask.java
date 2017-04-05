package com.java.base.tcp.uploadpic;

import java.io.*;
import java.net.Socket;

/**
 * Created by 1 on 2017/4/2.
 */
public class UpLoadPicTask implements Runnable {
    private Socket socket;

    public UpLoadPicTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
            //          为了避免覆盖，给重名的文件进行编号。
            File picFile = new File("D:\\workspace\\java-base\\src\\com\\java\\base", socket.getInetAddress() + ".jpg");
            int count = 0;
            while (picFile.exists()) {
                ++count;
                picFile = new File("D:\\workspace\\java-base\\src\\com\\java\\base", socket.getInetAddress() + "(" + count + ")" + ".jpg");
            }

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(picFile));

            byte[] buf = new byte[1024];
            int Len = 0;
            while ((Len = in.read(buf)) != -1) {
                bos.write(buf, 0, Len);
            }

            OutputStream out = socket.getOutputStream();
            out.write("上传图片成功".getBytes());
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
