package thread_pool;

/**
 * Created by 1 on 2017/3/16.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Bunises bunises = new Bunises();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    bunises.sub();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    bunises.main();
                }
            }
        }.start();
    }
}

class Bunises {

    private int count1 = 1;
    private int count2 = 1;
    private boolean flag = true;

    public synchronized void sub() {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("sub thread : " + i + "----LOOP : "+count1);
        }
        count1++;
        flag = false;
        this.notifyAll();
    }

    public synchronized void main() {
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 1; i <= 100; i++) {
            System.out.println("main thread : " + i + "----LOOP : "+count2);
        }
        flag = true;
        count2++;
        this.notifyAll();
    }

}
