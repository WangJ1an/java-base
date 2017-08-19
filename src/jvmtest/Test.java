package jvmtest;

/**
 * Created by 1 on 2017/8/7.
 */
public class Test {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        System.out.println("MAX memory: "+Runtime.getRuntime().maxMemory());
        System.out.println("free memory: "+Runtime.getRuntime().freeMemory());
        System.out.println("total memory: "+Runtime.getRuntime().totalMemory());

        byte[] b1 = new byte[_1MB];
        System.out.println("分配了1M");
        System.out.println("MAX memory: "+Runtime.getRuntime().maxMemory());
        System.out.println("free memory: "+Runtime.getRuntime().freeMemory());
        System.out.println("total memory: "+Runtime.getRuntime().totalMemory());
        byte[] b2 = new byte[4 * _1MB];
        System.out.println("分配了4M");
        System.out.println("MAX memory: "+Runtime.getRuntime().maxMemory());
        System.out.println("free memory: "+Runtime.getRuntime().freeMemory());
        System.out.println("total memory: "+Runtime.getRuntime().totalMemory());

    }
}
