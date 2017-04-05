package thread_pool;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 2017/3/20.
 */
public class ConditionTest {
        public static void main(String[] args) {

            final Business business = new Business();
            new Thread(
                    new Runnable() {

                        @Override
                        public void run() {

                            for(int i=1;i<=50;i++){
                                business.sub1(i);
                            }

                        }
                    }
            ).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <= 50; i++) {
                        business.sub2(i);
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=1;i<=50;i++){
                        business.main(i);
                    }
                }
            }).start();
        }

        static class Business {
            Lock lock = new ReentrantLock();
            Condition condition1 = lock.newCondition();
            Condition condition2 = lock.newCondition();
            Condition condition3 = lock.newCondition();
            private int condition = 1;
            public void sub1(int i) {
                lock.lock();
                try{
                    while(condition != 1){
                        try {
                            condition1.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    for(int j=1;j<=10;j++){
                        System.out.println("sub1 thread sequence of " + j + ",loop of " + i);
                    }
                    condition = 2;
                    condition2.signal();
                }finally{
                    lock.unlock();
                }
            }

            public void sub2(int i) {
                lock.lock();
                try {
                    while (condition != 2) {
                        condition2.await();
                    }
                    for (int j = 1; j <= 50; j++) {
                        System.out.println("sub2 thread sequence of " + j + ",loop of " + i);
                    }
                    condition = 3;
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public void main(int i) {
                lock.lock();
                try{
                    while(condition != 3){
                        try {
                            condition3.await();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    for(int j=1;j<=100;j++){
                        System.out.println("main thread sequence of " + j + ",loop of " + i);
                    }
                    condition = 1;
                    condition1.signal();
                }finally{
                    lock.unlock();
                }
            }

        }
    }

