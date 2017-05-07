package com.java.datastructure;

/**
 * Created by 1 on 2017/3/21.
 */
public class MyStackByLinked {
    private Node top;
    private int size;

    public void push(int data) {
        Node node = new Node(data,null);
        if (this.top == null) {
            this.top = node;
        }else {
            node.setNext(this.top);
            this.top = node;
        }
        this.size++;
    }

    public Node pop() {
        Node temp = null;
        if (this.isEmpty()) {
            System.out.println("栈为空");
        } else {
            temp = this.top;
            this.top = this.top.getNext();
            this.size--;
        }
        return temp;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        this.top = null;
    }

    public boolean isEmpty() {
        if (this.top == null) {
            return true;
        }
        return false;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyStackByLinked stack = new MyStackByLinked();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        System.out.println(stack.size);
        System.out.println(stack.pop().getData());
        System.out.println(stack.size);
        System.out.println(stack.pop().getData());
        System.out.println(stack.size);
        System.out.println(stack.isEmpty());
        stack.clear();
        System.out.println(stack.isEmpty());
    }
}
