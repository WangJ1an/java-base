package com.java.base.datastructure;

/**
 * Created by 1 on 2017/3/26.
 */
public class DoubleStack {
    private int top1;
    private int top2;
    private int[] array;
    private int size;

    public DoubleStack(int size) {
        top1 = -1;
        this.size = size;
        top2 = size - 1;
        array = new int[size];
    }

    public void push(int data, int number) {
        if (1 == number) {
            if (top1 + 1 == top2) {
                System.out.println("top1 is full");
                return;
            }
            array[++top1] = data;
        }

        if (2 == number) {
            if (top2 - 1 == top1) {
                array[top2] = data;
                return;
            }
            array[top2--] = data;
        }
    }

    public int pop(int number) {
        if (1 == number) {
            if (-1 == top1) {
                System.out.println("top1 is empty");
            } else {
                return array[top1--];
            }
        }

        if (2 == number) {
            if (size == top2) {
                System.out.println("top2 is empty");
            } else {
                return array[top2];
            }
        }

        return -1;
    }

    public void print() {
        System.out.println("top1 :");
        while (top1 != -1) {
            System.out.print(array[top1--]+" ");
        }
        System.out.println();
        System.out.println("top2 :");
        while (top2 != size) {
            System.out.print(array[top2++]+" ");
        }
    }

    public static void main(String[] args) {
        DoubleStack ds = new DoubleStack(5);
        ds.push(1,1);
        ds.push(3,1);
        ds.push(5,1);
        ds.push(2,2);
        ds.push(4,2);
        ds.print();
    }
}
