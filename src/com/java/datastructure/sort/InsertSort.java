package com.java.datastructure.sort;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/1.
 */
public class InsertSort {

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j-1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /*
    * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * */

    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[left]) {
                left = mid;
            } else if (array[mid] < array[right]) {
                right = mid;
            }
            if (right - 1 == left) {
                left = right;
                break;
            }
            if (left == right) {
                return array[left];
            }
        }

        return array[left];
    }

    @Test
    public void test() {
        int[] nums = {6,7,10,3,5,};
        System.out.println(minNumberInRotateArray(nums));
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,5};
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

}
