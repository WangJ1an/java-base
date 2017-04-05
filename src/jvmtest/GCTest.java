package jvmtest;

/**
 * Created by 1 on 2017/3/25.
 */
public class GCTest {

    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
            byte[] bytes = new byte[1000];
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testAllocation();
//        }
    }

    public static void testAllocation() {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
    private static final int _1MB = 1024 * 1024;
}
