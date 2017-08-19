package 剑指offer;

import java.util.Scanner;

/**
 * Created by 1 on 2017/8/9.
 */
public class chengji {
    /*
    * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
            输入描述:
            无序整数数组A[n]


            输出描述:
            满足条件的最大乘积

            输入例子1:
            3 4 1 2

            输出例子1:
            24
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new int[scanner.nextInt()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(fun(nums));
        }
    }

    public static int fun(int[] strs) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            int num = strs[i];
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}
