package com.java.datastructure.sort;

import org.junit.Test;

/**
 * Created by 1 on 2017/7/25.
 */
public class SelectSort {

    //每趟找出后面最小的进行交换
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int position = i;
            int temp = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    position = j;
                }
            }
            array[i] = array[position];
            array[position] = temp;
        }
    }

    @Test
    public void testSort() {
        int[] array = {23,1,15,2,5,6,4,3,11};
        selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
}
