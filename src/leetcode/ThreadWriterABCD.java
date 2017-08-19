package leetcode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 1 on 2017/6/20.
 */
public class ThreadWriterABCD {
    public static File fun(char ch) throws IOException {
        File file = new File(String.valueOf(ch));
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 4; i++) {
            char ch = (char)(64 + i);
            File file = fun(ch);
            NumberThread numberThread = new NumberThread(new FileOutputStream(file));
            numberThread.state = i;
            Thread t1 = new Thread(numberThread,"线程1");
            Thread t2 = new Thread(numberThread,"线程2");
            Thread t3 = new Thread(numberThread,"线程3");
            Thread t4 = new Thread(numberThread,"线程4");
            t1.start();
            t2.start();
            t3.start();
            t4.start();
        }

    }

    static class NumberThread implements Runnable {
        int count = 0;
        int state = 1;
        private FileOutputStream fos;

        public NumberThread(FileOutputStream fos) {
            this.fos = fos;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (Thread.currentThread().getName().contains(state+"")) {
                        try {
                            fos.write((state+"").getBytes());
                            count++;
                            state++;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (state == 5) {
                        state = 1;
                    }

                    this.notifyAll();

                    if (count == 12) {
                        break;
                    }
                }
            }
        }
    }
}
