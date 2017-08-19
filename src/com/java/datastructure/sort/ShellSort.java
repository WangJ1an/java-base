package com.java.datastructure.sort;

/**
 * Created by 1 on 2017/8/1.
 */
public class ShellSort {
    /**
     * 缩小增量排序，希尔排序
     */

    public static void sort(int[] nums) {

        //设置最大间隔
        int h = nums.length / 2;

        while (h > 0) {
            //进行插入排序
            for (int i = h; i < nums.length; i++) {
                int temp = nums[i];
                int j = i;
                while (j > h - 1 && nums[j - h] > temp) {
                    nums[j] = nums[j - h];
                    j = j - h;
                }
                nums[j] = temp;
            }
            //缩小间隔
            h = h / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,5,4,3,2,12,6,-3,2,5,6,7};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
