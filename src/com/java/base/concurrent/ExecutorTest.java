package com.java.base.concurrent;

import java.util.Vector;
import java.util.concurrent.*;

/**
 * Created by 1 on 2017/3/12.
 */
public class ExecutorTest {
    ExecutorService service = Executors.newCachedThreadPool();
    Vector<Future<String>> res = new Vector<Future<String>>();
    ExecutorCompletionService ecs = new ExecutorCompletionService(service,new ArrayBlockingQueue<Future>(10));

    class MyCallable implements Callable<String> {
        String result;
        MyCallable(String result) {
            this.result = result;
        }
        @Override
        public String call() throws Exception {
            return result;
        }
    }

    class MyRunable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {

            }
        }
    }

    void getTaskResult() {
        while (true) {
            int doneNum = 0;
            for (int i = 0; i < 20; i++) {
                Future f = ecs.poll();
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            if (doneNum == 20) {
                break;
            }
        }
    }

    void submitTasks1() {
        for (int i = 0; i < 10; i++) {
            Future<String> f = ecs.submit(new MyCallable("call "+i));
        }
        for (int i = 0; i < 10; i++) {
            Future<String> f = ecs.submit(new MyRunable(),"run "+i);
        }
    }

    void submitTasks() {
        for (int i = 0; i < 10; i++) {
            Future<String> f = service.submit(new MyCallable("call "+i));
            res.add(f);
        }
        for (int i = 0; i < 10; i++) {
            Future<String> f = service.submit(new MyRunable(),"run "+i);
            res.add(f);
        }
    }

    void dumpResult() {
        for (Future<String> f : res) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    void test() {
//        submitTasks();
//        dumpResult();
//        service.shutdown();
        submitTasks1();
        getTaskResult();
        service.shutdown();
    }

    public static void main(String[] args) {
        new ExecutorTest().test();
    }
}
