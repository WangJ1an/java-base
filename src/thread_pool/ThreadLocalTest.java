package thread_pool;

import java.util.Random;

/**
 * Created by 1 on 2017/3/19.
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> x = new ThreadLocal<>();
    private static ThreadLocal<ThreadScopeData> threadScopeData = new ThreadLocal<>();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    int num = new Random().nextInt(30);
                    System.out.println(Thread.currentThread().getName() + " add num : " + num);
                    x.set(num);
//                    ThreadScopeData data = new ThreadScopeData("name"+num,num);
                    ThreadScopeData.getThreadInstance().setName("name"+num);
                    ThreadScopeData.getThreadInstance().setAge(num);
                    new A().get();
                    new B().get();
                }
            }.start();
        }
    }

    static class A {
        public void get() {
            ThreadScopeData data = ThreadScopeData.getThreadInstance();
            System.out.println("B : " + Thread.currentThread().getName() + " get name " + data.getName()
                    + " get age " + data.getAge());
        }
    }

    static class B {
        public void get() {
            ThreadScopeData data = ThreadScopeData.getThreadInstance();
            System.out.println("A : " + Thread.currentThread().getName() + " get name " + data.getName()
                    + " get age " + data.getAge());
        }
    }
}

class ThreadScopeData {
    private String name;
    private int age;
    private static ThreadLocal<ThreadScopeData> map = new ThreadLocal<>();

    public static ThreadScopeData getThreadInstance() {
        if (map.get() == null) {
            map.set(new ThreadScopeData());
        }
        return map.get();
    }

    public ThreadScopeData() {}

    public ThreadScopeData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}