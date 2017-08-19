package leetcode;

/**
 * Created by 1 on 2017/8/1.
 */
public class MaxSubSum {
    //最大子序列和，子序列是连续的
    public static void main(String[] args) {
        int[] nums = {4,-3,5,-2,-1,2,6,-2};
        System.out.println(subSum(nums));
    }


    //如果nums[i]是负的。那么它不可能是最优子序列的起点
    //同样，如果一个子序列是负的，那它不可能是最优子序列的前缀
    public static int subSum(int[] nums) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < nums.length; i++) {
            thisSum += nums[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
