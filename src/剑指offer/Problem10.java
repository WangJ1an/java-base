package 剑指offer;

import org.junit.*;

/**
 * Created by 1 on 2017/8/10.
 */
public class Problem10 {
    /**
     * 判断一个数二进制中1的个数
     * @param n
     */
    public void toBin(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        System.out.println(count);
    }
    @org.junit.Test
    public void fun() {
        int num = -3;
        toBin(num);
    }
}
