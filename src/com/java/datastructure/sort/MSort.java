package com.java.datastructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by 1 on 2017/8/9.
 */
public class MSort {

    public void sort(int[] nums) {
        sort(nums,0,nums.length - 1);
    }
    public void sort(int[] nums, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(nums,middle+1,end);
            sort(nums,start,middle);
            merge(nums,start,middle,end);
        }
    }


    private void merge(int[] nums, int start, int middle, int end) {
        int[] temp = new int[end - start + 1];
        int index0 = start;
        int k = 0;
        int index1 = middle+1;
        while (index0 <= middle && index1 <= end) {
            if (nums[index0] <= nums[index1]) {
                temp[k++] = nums[index0++];
            } else {
                temp[k++] = nums[index1++];
            }
        }
        while (index0 <= middle) {
            temp[k++] = nums[index0++];
        }
        while (index1 <= end) {
            temp[k++] = nums[index1++];
        }
        for (k = 0; k < temp.length; k++) {
            nums[start+k] = temp[k];
        }
    }

    @Test
    public void test() {
        int[] nums = {1,5,4,2,3,70,23,4,2,25,65,-3,-2};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

}
