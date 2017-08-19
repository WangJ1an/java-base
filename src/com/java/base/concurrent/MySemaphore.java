package com.java.base.concurrent;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by 1 on 2017/8/17.
 */
public class MySemaphore {

    private final Sync sync;

    public MySemaphore(int permits, boolean isFair) {
        sync = isFair ? new FairSync(permits) : new NoFairSync(permits);
    }

    public void acquire() {
        sync.acquireShared(1);
    }

    public boolean release() {
        return sync.releaseShared(1);
    }

    private static class Sync extends AbstractQueuedSynchronizer {
        Sync(int permits) {
            setState(permits);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (;;) {
                int available = getState();
                int next = available + arg;
                if (next < available)
                    throw new Error("Maximum permit count exceeded");
                if (compareAndSetState(available,next)) {
                    return true;
                }
            }
        }
    }

    private static class NoFairSync extends Sync {

        NoFairSync(int permits) {
            super(permits);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;) {
                int available = getState();
                int remaing = available - arg;
                if (remaing < 0 || compareAndSetState(available,remaing)) {
                    return remaing;
                }
            }
        }
    }


    private static class FairSync extends Sync {

        FairSync(int permits) {
            super(permits);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;) {
                if (hasQueuedPredecessors()) {
                    return -1;
                }
                int available = getState();
                int remaing = available - arg;
                if (remaing < 0 || compareAndSetState(available,remaing)) {
                    return remaing;
                }
            }
        }
    }

    public static void main(String[] args) {
        MySemaphore semaphore = new MySemaphore(2,false);
        for (int i = 0; i < 10; i++) {
            new Thread(String.valueOf(i+1)) {
                @Override
                public void run() {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"获得许可");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release();
                }
            }.start();
        }
    }
}
