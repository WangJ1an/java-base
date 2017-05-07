package com.java.datastructure;


/**
 * Created by 1 on 2017/3/26.
 */
public class MyStackByArray {
    private int[] array;
    private int top = -1;
    final private int size;

    public MyStackByArray(int size) {
        this.size = size;
        array = new int[size];
    }

    public void push(int data) {
        if (top == size - 1) {
            System.out.println("Stack is Full");
            return;
        }
        array[++top] = data;
    }

    public int pop() {
        if (-1 == top) {
            return -1;
        }
        return array[top--];
    }

    /*public void print() {
        for (int i = top; i > -1; i--) {
            System.out.println(array[i]);
        }
    }*/


    public static void main(String[] args) {
        MyStackByArray sb = new MyStackByArray(4);
        sb.push(1);
        sb.push(3);
        sb.push(4);
        sb.push(5);
        System.out.println(sb.pop());
        System.out.println(sb.pop());
        System.out.println(sb.pop());
        System.out.println(sb.pop());
    }
}
