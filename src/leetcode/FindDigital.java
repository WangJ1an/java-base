package leetcode;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by 1 on 2017/4/16.
 */
public class FindDigital {
    //从n个数据中找出前m个最大的数，时间复杂度 <= O(n)
    //采用堆排序先选前个元素组成一个小根堆，然后遍历剩下的数据，如果第i个元素key大于小根堆的根节点，就
    //用key替换这个这个根节点，然后重新生成小根堆，继续遍历剩下的数据，最后这个小根堆里的m个元素就是前m个
    //最大的数，时间复杂度为O((n-m)*lgm),空间复杂度为O(m)

    public void heapSort(int[] array) {
        creatMinHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - 1 - i);
            adjust(array, 0, array.length - 1 - i);
        }
    }

    private void creatMinHeap(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        //从最后的一个非叶子节点向上开始排,避免迭代没有意义的叶子节点
        for (int i = (array.length - 1)/2; i >= 0; i--) {
            adjust(array, i, array.length);
        }
    }

    public void adjust(int[] array, int root, int length) {
        int left = 2*root+1;
        if (left >= length) {
            return;
        }
        if (left + 1 < length && array[left+1] < array[left]) {
            left++;
        }
        if (array[root] > array[left]) {
            swap(array, root, left);
            adjust(array, left, length);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void findDigital(int[] datas, int m) {
        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = datas[i];
        }
        heapSort(temp);
        for (int i = m; i < datas.length; i++) {
            if (datas[i] > temp[0]) {
                temp[0] = datas[i];
                adjust(temp, 0, temp.length);
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.print(temp[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,11,2,7,8,10};
        new FindDigital().heapSort(nums);
        for (int i :
                nums) {
            System.out.print(i+" ");
        }
        new FindDigital().findDigital(nums,3);
    }

}
