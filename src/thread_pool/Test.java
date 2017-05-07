package thread_pool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 2017/4/11.
 */
public class Test {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        final int[] condition = {1};
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    while (condition[0] != 1) {
                        try {
                            conditionA.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    condition[0] = 2;
                    conditionB.signal();
                    lock.unlock();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (condition[0] != 2) {
                            conditionB.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B");
                    condition[0] = 3;
                    conditionC.signal();
                    lock.unlock();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (condition[0] != 3) {
                            conditionC.await();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("C");
                    condition[0] = 1;
                    conditionA.signal();
                    lock.unlock();
                }
            }
        }.start();
    }

}
