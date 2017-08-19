package 剑指offer;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/11.
 */
public class Problem12 {
    /**
     * 最大子数组和
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxsum = Integer.MIN_VALUE;
        int thissum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > thissum && thissum < 0) {
                thissum = array[i];
            } else {
                thissum += array[i];
            }

            if (maxsum < thissum) {
                maxsum = thissum;
            }
        }
        return maxsum;
    }

    @Test
    public void fun() {
        int[] nums = new int[]{-2,-8,-1,-5,-9};
        int n = FindGreatestSumOfSubArray(nums);
        System.out.println(n);
    }
}
