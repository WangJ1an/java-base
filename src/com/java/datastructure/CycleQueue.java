package com.java.datastructure;

/**
 * Created by 1 on 2017/4/4.
 */
public class CycleQueue {
    private int head;
    private int tail;
    private int[] datas;
    private int count;

    public CycleQueue(int size) {
        datas = new int[size];
    }

    public void add(int num) {
        if (count == datas.length) {
            System.out.println("队列已满");
            return;
        }
        datas[tail] = num;
        tail = (tail+1)%datas.length;
        count++;
    }

    public int remove() {
        if (count == 0) {
            throw new RuntimeException("队列为空");
        }
        int temp = datas[head];
        head = (head+1)%datas.length;
        count--;
        return temp;
    }

    public static void main(String[] args) {
        CycleQueue cq = new CycleQueue(3);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        cq.add(4);
        cq.add(5);
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        cq.add(6);
        cq.add(7);
        cq.add(8);
        cq.add(9);
        System.out.println(cq.remove());
        System.out.println(cq.remove());
        System.out.println(cq.remove());
    }
}
