package com.java.base.concurrent;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 1 on 2017/3/12.
 */
public class Test {

    public void testVector() throws InterruptedException {
        Vector<Integer> vector = new Vector<Integer>();
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    vector.add(i);
                }
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 100; i < 200; i++) {
                    vector.add(i);
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 200; i < 300; i++) {
                    vector.add(i);
                }
            }
        };

        thread0.start();
        thread1.start();
        thread2.start();

        Thread.sleep(100);
        ListIterator it = vector.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void testABQ() throws InterruptedException {

        ArrayBlockingQueue abq = new ArrayBlockingQueue(10);

        Lock lock = new ReentrantLock();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    try {
                        abq.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    if (!abq.isEmpty()) {
                        try {
                            System.out.println(abq.take());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                lock.unlock();
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    public void testCopyArrayList() throws InterruptedException {
        CopyOnWriteArrayList ca = new CopyOnWriteArrayList();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    ca.add(i);
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                printByIt(ca.iterator());
//                for (int i = 0; i < 100; i++) {
//                    System.out.println(ca.get(i));
//                }
            }
        };

        t1.start();
        t2.start();

//        ThreadDemo.sleep(10);
//        printByIt(ca.iterator());
    }

    public void testConcurrentHashMap() throws InterruptedException {
        ConcurrentHashMap<Integer,Integer> chm = new ConcurrentHashMap<>();
        Random random = new Random();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    chm.put(i,random.nextInt(1000));
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1000; i < 2000; i++) {
                    chm.put(i,random.nextInt(1000));
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                for (int i = 2000; i < 3000; i++) {
                    chm.put(i,random.nextInt(1000));
                }
            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                for (int i = 3000; i < 4000; i++) {
                    chm.put(i,random.nextInt(1000));
                }
            }
        };
        Thread t5 = new Thread() {
            @Override
            public void run() {
                for (int i = 4000; i < 5000; i++) {
                    chm.put(i,random.nextInt(1000));
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (Exception e) {

        }

        Thread.sleep(10);
        for (Map.Entry<Integer,Integer> me : chm.entrySet()) {
            System.out.println(me.getKey()+" -------> "+me.getValue());
        }

    }

    public void printByIt(Iterator it) {
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        new Test1().testVector();
        new Test().testABQ();
//          new Test1().testConcurrentHashMap();
    }
}
