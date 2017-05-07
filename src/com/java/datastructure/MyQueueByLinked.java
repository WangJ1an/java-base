package com.java.datastructure;

/**
 * Created by 1 on 2017/4/4.
 */
public class MyQueueByLinked {

    private Node head;

    private Node tail;

    private int size = -1;

    private int count;

    public MyQueueByLinked() {}

    public MyQueueByLinked(int size) {
        if (size <= 0) {
            throw new RuntimeException("输入SIZE错误");
        }
        this.size = size;
        count = 0;

    }

    public void add(int data) {
        if (count == size) {
            System.out.println("队列已满");
            return;
        }
        Node node = new Node(data,null);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            head.setNext(tail);
            count++;
            return;
        }
        this.tail.setNext(node);
        this.tail = node;
        count++;
    }

    public int remove() {
        if (this.head == null) {
            return -1;
        }
        Node temp = this.head;
        this.head = this.head.getNext();
        count--;
        return temp.getData();
    }

    public void print() {
        if (this.head == null) {
            System.out.println("队列为空");
            return;
        }
        Node p = this.head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyQueueByLinked queue = new MyQueueByLinked(-1);
        queue.add(2);
        queue.add(7);
        queue.add(6);
        queue.print();
        queue.add(3);
        queue.print();
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
