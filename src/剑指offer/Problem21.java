package 剑指offer;

import org.junit.Test;


/**
 * Created by 1 on 2017/8/12.
 */
public class Problem21 {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。
     * @param array
     */
    public void FindNumsAppearOnce(int [] array) {
        if (array.length <= 0) {
            return;
        }
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp ^= array[i];
        }
        int index = 0;
        while ((temp & 1) == 0) {
            temp = temp >>> 1;
            index++;
        }
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i],index) == 1) {
                num1 ^= array[i];
            } else {
                num2 ^= array[i];
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }

    private int isBit(int i, int index) {
        int k = i >>> index;
        return k&1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(nums);
    }

}
