package thread_pool;

/**
 * Created by 1 on 2017/3/19.
 */
public class ThreadTest {
    private static int j = 10;
    public static void main(String[] args) {
        Inc inc = new Inc(j);
        Dec dec = new Dec(j);

        Thread thread1 = new Thread(inc);
        Thread thread2 = new Thread(inc);
        Thread thread3 = new Thread(dec);
        Thread thread4 = new Thread(dec);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    static class Inc implements Runnable {
        private int num;

        public Inc(int num) {
            this.num = num;
        }

        private synchronized void inc() {
            this.num++;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                this.inc();
                System.out.println(Thread.currentThread().getName() + " ----->Inc num : " + num);
            }
        }
    }

    static class Dec implements Runnable {
        private int num;

        public Dec(int num) {
            this.num = num;
        }

        private synchronized void dec() {
            this.num--;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                this.dec();
                System.out.println(Thread.currentThread().getName() + " ----->Dec num : " + num);
            }
        }
    }
}
