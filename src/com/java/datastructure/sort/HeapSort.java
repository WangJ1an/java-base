package com.java.datastructure.sort;


import com.java.base.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/3/1.
 */
public class HeapSort {
    public static<T> void swap(List<T> list,int i,int j) {
        if (list.get(i).equals(list.get(j)))
            return;
        T temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    public static<T> void creatMaxdHeap(List<T> list,int lastindex,Compare<T> compare) {
        for (int i = (lastindex - 1) / 2; i >= 0; i--) {
            //保存当前正在判断的节点(第一个非叶子节点)到k
            int k = i;
            //若当前节点的子节点存在
            while (2 * k + 1 <= lastindex) {
                //先给biggerIndex赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastindex) {
                    //若右子节点存在，判断左右子节点的大小，若右大于左，则将biggerIndex赋值为右子节点
                    if (compare.compare(list.get(biggerIndex),list.get(biggerIndex + 1)) < 0) {
                        biggerIndex++;
                    }
                }
                //比较当前节点值与子节点中最大值的大小
                if (compare.compare(list.get(k),list.get(biggerIndex)) < 0) {
                    swap(list,k,biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    public static<T> void heapSort(List<T> list,Compare<T> compare) {
        for (int i = 0; i < list.size(); i++) {
            creatMaxdHeap(list,list.size() - 1 - i, compare);
            swap(list,0,list.size() - 1 - i);
        }
    }

    public static<T> void print(int[] data) {
        for (int d : data) {
            System.out.print("[");
            System.out.print(d+",");
            System.out.print("]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("李四",26));
        list.add(new Person("张三",23));
        list.add(new Person("王五",25));
        list.add(new Person("小明",14));
        list.add(new Person("小红",16));
        for (Person n : list) System.out.print(n.toString() + " ");
        heapSort(list, new Person());
        System.out.println("排序后：");
        for (Person n : list) System.out.print(n.toString() + " ");
    }
}
