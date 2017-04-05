package com.java.base.datastructure;

/**
 * Created by 1 on 2017/4/4.
 */
public class MyQueueByArray {
    private int datas[];
    private int head = -1;
    private int tail = 0;
    private int size;

    public MyQueueByArray(int size) {
        this.size = size;
        datas = new int[this.size];
    }

    public void add(int num) {
        if (tail == size) {
            System.out.println("队列已满");
            return;
        }
        if (head == -1) {
            datas[tail++] = num;
            head++;
        } else {
            datas[tail++] = num;
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int temp = datas[head++];
        return temp;
    }

    public boolean isEmpty() {
        return head == -1 || head == tail;
    }

    public static void main(String[] args) {
        MyQueueByArray qba = new MyQueueByArray(3);
        qba.add(1);
        qba.add(2);
        qba.add(3);
        qba.add(4);
        System.out.println(qba.remove());
        System.out.println(qba.remove());
        System.out.println(qba.remove());
    }
}
