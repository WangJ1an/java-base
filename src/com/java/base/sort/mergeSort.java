package com.java.base.sort;

import com.java.base.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/3/1.
 */
public class mergeSort {
    public static<T> void mSort(List<T> list,Compare<T> compare) {
        mergeSort(list, 0,list.size() - 1, compare);
    }

    private  static<T> void mergeSort(List<T> list,int start,int end,Compare<T> compare) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(list, start, mid, compare);
            mergeSort(list, mid + 1, end, compare);
            merge(list, start, mid, end, compare);
        }
    }
    public static<T> void merge(List<T> list,int start,int mid,int end,Compare<T> compare) {
        List<T> temp = new ArrayList<>();
        int index1 = start;
        int index2 = mid + 1;
        while (index1 <= mid && index2 <= end) {
            if (compare.compare(list.get(index1),list.get(index2)) < 0) {
                temp.add(list.get(index1++));
            } else {
                temp.add(list.get(index2++));
            }
        }

        while (index1 <= mid) {
            temp.add(list.get(index1++));
        }

        while (index2 <= end) {
            temp.add(list.get(index2++));
        }
        for (T target : temp) {
            list.set(start++,target);
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>(5);
        list.add(new Person("b",26));
        list.add(new Person("c",23));
        list.add(new Person("d",25));
        list.add(new Person("e",14));
        list.add(new Person("a",16));
        for (Person n : list) System.out.print(n.toString() + " ");
        mSort(list, new Compare<Person>() { //覆盖为通过比较姓名的方式排序
            @Override
            public int compare(Person value1, Person value2) {
                return value1.getName().compareTo(value2.getName());
            }
        });
        System.out.println("排序后：");
        for (Person n : list) System.out.print(n.toString() + " ");
    }

    public static void print(int[] data) {
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            if (i == data.length - 1) {
                System.out.print(data[i]);
            } else {
                System.out.print(data[i]+",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
