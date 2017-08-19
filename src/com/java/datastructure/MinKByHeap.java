package com.java.datastructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 1 on 2017/8/10.
 */
public class MinKByHeap {
    /**
     * 输入n个整数，找出其中最小的K个数。
     * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k > input.length) {
            return arrayList;
        }
        int[] maxDui = createMax(input,k);

        if (k < input.length) {
            for (int i = k; i < input.length; i++) {
                if (maxDui[0] > input[i]) {
                    maxDui[0] = input[i];
                    adjustMaxDui(maxDui);
                }
            }
        }
        for (int i = 0; i < maxDui.length; i++) {
            arrayList.add(maxDui[i]);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private int[] createMax(int[] input, int k) {
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = input[i];
        }

        adjustMaxDui(nums);
        return nums;
    }

    private void adjustMaxDui(int[] nums) {
        for (int i = (nums.length - 2) / 2; i >= 0 ; i--) {
            //取得第一个非叶子节点
            int k = i;
            while (2*k+1 <= nums.length - 1) {
                //赋值为左子节点
                int biggerIndex = 2*k+1;
                if (biggerIndex < nums.length - 1 &&
                        nums[biggerIndex] < nums[biggerIndex+1]) {
                    biggerIndex++;
                }
                if (nums[k] < nums[biggerIndex]) {
                    int temp = nums[k];
                    nums[k] = nums[biggerIndex];
                    nums[biggerIndex] = temp;
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    @Test
    public void test() {
//        [4,5,1,6,2,7,3,8],4
        int[] nums = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(nums,3);
        System.out.println(arrayList.toString());
    }
}
