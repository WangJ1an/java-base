package com.java.base.datastructure;

/**
 * Created by 1 on 2017/3/11.
 */
public class MyDoubleLikedList {
    private Node head;

    public void headInsert(int data) {
        Node node = new Node(data,null,null);
        if (null == this.head) {
            this.head = node;
        }
        node.setNext(head);
        head.setPrevious(node);
        head = node;
    }

    public void tailInsert(int data) {
        Node node = new Node(data,null,null);
        if (null == this.head) {
            this.head = node;
        }
        Node p = head;
        while (null != p.getNext()){
            p = p.getNext();
        }
        p.setNext(node);
        node.setPrevious(p);
    }

    public void insert(int data) {
        Node node = new Node(data,null,null);

        if (null == this.head) {
            this.head = node;
            return;
        }

        if (this.head.getData() > data) {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
            return;
        }

        Node p = head;
        while (null != p.getNext()) {
            if (p.getNext().getData() >= data) {
                break;
            }
            p = p.getNext();
        }
        if (p.getNext() == null) {
            p.setNext(node);
            node.setPrevious(p);
            return;
        }

        p.getNext().setPrevious(node);
        node.setNext(p.getNext());
        p.setNext(node);
        node.setPrevious(p);
    }

    public void removeHead() {
        this.head = this.head.getNext();
    }

    public void removeTail() {
        Node p = head;
        while (null != p.getNext()) {
            p = p.getNext();
        }
        p.getPrevious().setNext(null);
        p.setPrevious(null);
    }

    public void remove(int data) {
        if (this.head.getData() == data) {
            this.head = this.head.getNext();
            return;
        }

        Node p = head;
        while (null != p.getNext()) {
            if (p.getNext().getData() == data) {
                break;
            }
            p = p.getNext();
        }
        if (p.getNext() == null) {
            System.out.println("元素不存在");
            return;
        }
//        若data为最后一个元素的删除方式，此时P指向data的前一个元素。 元素A（P）  元素node（data）  NULL
        if (p.getNext().getNext() == null && p.getNext().getData() == data) {
            p.getNext().setPrevious(null);
            p.setNext(null);
            return;
        }
//        中间元素的删除方式。   元素A（P）   元素node（data）  元素C
        p.setNext(p.getNext().getNext());
        p.getNext().setPrevious(p);
    }

    public void print() {
        if (null == this.head) {
            System.out.println("空链表");
            return;
        }
        Node p = head;
        while (null != p) {
            System.out.print(p.getData()+"  ");
            p = p.getNext();
        }
        System.out.println();
    }

    private class Node {
        private Node next;
        private Node previous;
        private int data;

        public Node(int data,Node next, Node previous) {
            this.next = next;
            this.previous = previous;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyDoubleLikedList dll = new MyDoubleLikedList();
        dll.insert(3);
        dll.insert(2);
        dll.insert(5);
        dll.insert(0);
        dll.insert(1);
        dll.insert(6);
        dll.tailInsert(3);
        dll.headInsert(10);
        dll.print();
        dll.removeHead();
        dll.removeTail();
        dll.remove(6);
        dll.remove(20);
        dll.print();
    }
}
