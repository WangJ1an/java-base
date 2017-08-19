package com.java.datastructure;

/**
 * 求N个海量数据中最大的K数
 * 解决方案：先将前K个数创建小根堆，而后每遍历到一个数据与小根堆的根比较，如果比它大
 * 则将根替换为该数重新调整为小根堆
 * 时间复杂度NlogK
 *
 * Created by 1 on 2017/5/20.
 */
public class TopKByHeap {

    private int[] createMinHeap(int[] data) {
        adjustMinHeap(data);
        return data;
    }

    private void adjustMinHeap(int[] data) {
        //从最后一个非叶子节点开始往前循环
        for (int i = (data.length - 2) / 2; i >= 0 ; i--) {
            //取得最后一个非叶子节点
            int k = i;
            while (2*k+1 < data.length) {
                //取得其左子节点
                int minIndex = 2 * k + 1;
                //minIndex指向为左右子节点中小的那个
                if (minIndex+1 < data.length && data[minIndex] > data[minIndex+1]) {
                    minIndex++;
                }
                //与它们的父节点比较，看哪个最小
                if (data[k] > data[minIndex]) {
                    int temp = data[k];
                    data[k] = data[minIndex];
                    data[minIndex] = temp;
                    k = minIndex;
                } else {
                    break;
                }
            }
        }

    }

    public int[] getTopK(int[] data, int k) {
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = data[i];
        }

        this.createMinHeap(nums);

        for (int i = k; i < data.length; i++) {
            if (data[i] > nums[0]) {
                nums[0] = data[i];
                this.adjustMinHeap(nums);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] datas = {3,6,1,7,2,10,7,11,16,13};
        int[] nums = new TopKByHeap().getTopK(datas,5);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }

    }

}
