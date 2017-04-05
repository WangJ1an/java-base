package thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 1 on 2017/3/21.
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()
                            +"进入，当前已有"+(3-sp.availablePermits())+"个并发");

                    try {
                        Thread.sleep((long)(Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()
                            +"即将离开");
                    sp.release();
                    //下面代码有时候不准确，因为没有和上面合成原子操作
                    System.out.println("线程"+Thread.currentThread().getName()+
                            "已离开，当前已有"+(3-sp.availablePermits())+"个并发");
                }
            };
            service.execute(runnable);
        }
    }
}
