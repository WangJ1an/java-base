package thread_pool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by 1 on 2017/3/16.
 */
public class TimerDemo {

    private static int count = 0;

    static class  MyTimerTask2 extends TimerTask {
        @Override
        public void run() {
            System.out.println("bombing");
            new Timer().schedule(new MyTimerTask1(),2000);
        }
    }
    static class MyTimerTask1 extends TimerTask {
        @Override
        public void run() {
//                count = (count+1) % 2;
            System.out.println("bombing");
            new Timer().schedule(new MyTimerTask2(),4000);
        }
    }

    public static void main(String[] args) {

        new Timer().schedule(new MyTimerTask1(),2000);

        while(true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
