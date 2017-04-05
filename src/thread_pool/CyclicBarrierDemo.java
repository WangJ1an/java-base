package thread_pool;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by 1 on 2017/3/19.
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        Runnable barrierrunnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("barrierunnable 1 executed");
            }
        };

        Runnable barrierrunable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("barrierrunnable 2 executed");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(2,barrierrunnable1);
        CyclicBarrier barrier2 = new CyclicBarrier(2,barrierrunable2);

        CyclicBarrierRunnable c1 = new CyclicBarrierRunnable(barrier1,barrier2);
        CyclicBarrierRunnable c2 = new CyclicBarrierRunnable(barrier1,barrier2);

        new Thread(c1).start();
        new Thread(c2).start();
    }

}

class CyclicBarrierRunnable implements Runnable {

    private CyclicBarrier barrier1 = null;
    private CyclicBarrier barrier2 = null;

    public CyclicBarrierRunnable(CyclicBarrier cb1, CyclicBarrier cb2) {
        this.barrier1 = cb1;
        this.barrier2 = cb2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"------"+"waiting at barrier1");
            this.barrier1.await();

            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"------"+"waiting at barrier2");
            this.barrier2.await();

            System.out.println(Thread.currentThread().getName() + " done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
