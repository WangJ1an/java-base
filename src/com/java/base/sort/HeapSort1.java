package com.java.base.sort;


import java.util.Arrays;

/**
 * Created by asus on 2017/2/25.
 */
public class HeapSort1 {

    public static void main(String[] args) {
        Integer[] datas = {5, 10, 9, 11, 6};
        sort(datas);

        System.out.printf("排序后的结果为：[ ");
        for(int n : datas){
            System.out.printf(n+" ");
        }
        System.out.printf("]\n");

        System.out.println(Arrays.asList(datas));
    }


    //调整为大根堆
    static void adjust(Integer[] datas, int root, int length) {
        int left = 2*root+1;

        if (left >= length){
            return;
        }
        if (left + 1 < length && datas[left] < datas[left + 1]){
            ++ left;
        }
        if(datas[root] < datas[left]){
            swap(datas, root, left);
            adjust(datas,left,length);
        }
    }

    //创建大根堆
    static void creat(Integer[] datas) {
        int length = datas.length;
        for(int i = datas.length/2 - 1; i >= 0; --i){
            adjust(datas, i, length);
        }
    }

    //堆排序
    static void sort(Integer[] datas){
        creat(datas);
        for(int i = 0; i<datas.length; ++i){
            swap(datas, 0, datas.length - 1 - i);
            adjust(datas, 0, datas.length - 1 - i);
        }
    }

    //数据交换
    private static void swap(Integer[] datas, int i, int j){
        int temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

}



