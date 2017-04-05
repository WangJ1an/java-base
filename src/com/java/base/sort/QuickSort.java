package com.java.base.sort;

import com.java.base.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/2/24.
 */
public class QuickSort {
    static <T> int getMiddle (List<T> list,int left,int right,Compare<T> compare){
        T point = list.get(left);
        while (left < right){
            while (left < right && compare.compare(list.get(right),point) > 0) {
                --right;
            }
            list.set(left, list.get(right));
            while (left < right && compare.compare(list.get(left),point) < 0) {
                ++left;
            }
            list.set(right,list.get(left));
        }
        list.set(left,point);
        return left;
    }

    static <T> void Sort (List<T> list, int left , int right,Compare<T> compare){
        if (left > right) {
            return;
        }
            int mid = getMiddle(list, left, right, compare);
            Sort(list,left, mid - 1, compare);
            Sort(list, mid + 1, right, compare);
    }

    public static void main(String[] args){
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("李四",26));
        list.add(new Person("张三",23));
        list.add(new Person("王五",25));
        list.add(new Person("小明",14));
        list.add(new Person("小红",16));
        for (Person n : list) System.out.print(n.toString() + " ");
        Sort(list, 0, list.size() - 1,new Person());
        System.out.println();
        for (Person n : list) System.out.print(n.toString() + " ");
    }
}
