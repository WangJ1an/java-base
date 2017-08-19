package 剑指offer;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/11.
 */
public class Problem13 {
    /**
     *
     编程之美上给出的规律：


     1. 如果第i位（自右至左，从1开始标号）上的数字为0，则第i位可能出现1的次数由更高位决定（若没有高位，视高位为0），
     等于更高位数字X当前位数的权重10i-1。


     2. 如果第i位上的数字为1，则第i位上可能出现1的次数不仅受更高位影响，还受低位影响（若没有低位，视低位为0），
     等于更高位数字X当前位数的权重10i-1+（低位数字+1）。


     3. 如果第i位上的数字大于1，则第i位上可能出现1的次数仅由更高位决定（若没有高位，视高位为0），
     等于（更高位数字+1）X当前位数的权重10i-1。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int high,low,curr,tmp,i = 1;
        int key = 1;
        high = n;
        int count = 0;
        while (high != 0) {
            high = (int) (n / Math.pow(10,i));
            tmp = (int) (n % Math.pow(10,i));
            curr = (int) (tmp / Math.pow(10,i - 1));
            low = (int) (tmp % Math.pow(10,i-1));
            if (curr==key) {
                count += high * Math.pow(10,i-1) + low + 1;
            } else if (curr > key) {
                count += (high + 1) * Math.pow(10,i-1);
            } else if (curr < key) {
                count += high * Math.pow(10,i-1);
            }
            i++;
        }
        return count;
    }

    @Test
    public void test() {

    }
}
