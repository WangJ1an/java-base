package com.java.datastructure;

/**
 * Created by 1 on 2017/3/11.
 */
//线性表----顺序存储
public class MyArrayList {
    public static void main(String[] args) {
        myList list = new myList(10);
        list.insert(3);
        list.insert(5);
        list.insert(4);
        list.insert(2);
        list.insert(6);
        list.print();
        list.remove(4);
        list.print();
    }
}

class myList {
    private int[] datas;
    private int length;
    private int size;

    public myList(int size) {
        this.size = size;
        this.datas = new int[size] ;
    }

    public void insert(int key) {
        if (length+1 > size) {
            System.out.println("已存满");
            return;
        }
        if (0 == this.length){
            datas[length++] = key;
            return;
        }

        int location = this.length;
        for (int i = 0; i < this.length; i++) {
            if (this.datas[i] > key) {
                location = i;
                break;
            }
        }

        for (int i = this.length - 1; i >= location; i--) {
            datas[i+1] = datas[i];
        }

        this.datas[location] = key;
        this.length++;
    }

    public void remove(int key){
        if (0 == this.length) {
            System.out.println("空的线性表");
            return;
        }

        int location = -1;
        for (int i = 0; i < this.length; i++) {
            if (datas[i] == key){
                location = i;
            }
        }

        if (-1 == location) {
            System.out.println("数据不存在");
            return;
        }

        for (int i = location; i < this.length - 1; i++) {
            datas[i] = datas[i+1];
        }
        --this.length;
    }

    public void print() {
        for (int i = 0; i < this.length; i++) {
            System.out.print(datas[i]+"   ");
        }
        System.out.println();
    }
}
