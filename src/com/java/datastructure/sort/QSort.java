package com.java.datastructure.sort;

/**
 * Created by 1 on 2017/3/19.
 */
public class QSort {

    public static void quickSort(int array[], int low, int high) {
        if (low < high) {
            int mid = getMiddle(array, low, high);
            quickSort(array, low, mid - 1);
            quickSort(array, mid + 1, high);
        }
    }

    public static int getMiddle(int array[], int left , int right) {
        int point = array[left];
        while (left < right) {
            while (left < right && array[right] >= point) {
                right--;
            }
            array[left] = array[right];

            while (left < right && array[left] <= point) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = point;
        return left;
    }

    public static void main(String[] args) {
        int num[] = {3,6,2,5,19,26,25,14,13,16,12};
        quickSort(num, 0, num.length - 1);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "  ");
        }
    }
}
