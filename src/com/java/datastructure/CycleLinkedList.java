package com.java.datastructure;

import java.util.HashSet;

/**
 * Created by 1 on 2017/3/21.
 */
public class CycleLinkedList {
    private Node head;
    private Node tail;

    public void headInsert(int data) {
        Node node = new Node(data, null);
        if (head == null) {
            this.head = node;
            this.tail = node;
        }
        node.setNext(head);
        this.head = node;
        this.tail.setNext(this.head);
    }

    public void tailInsert(int data) {
        Node node = new Node(data,null);
        if (head == null) {
            this.head = node;
            this.tail = node;
            tail.setNext(head);
            return;
        }
        Node p = head;
        while (p.getNext() != null) {
            if (p.getNext() == head) {
                p.setNext(node);
                tail = node;
                node.setNext(head);
                return;
            }
            p = p.getNext();
        }
    }

    public void insert(int data) {

    }

    public void remove(int data) {
        Node node = new Node(data,null);
        if (null == this.head) {
            System.out.println("该链表为空");
            return;
        }
        if (this.head.getData() == node.getData()) {
            this.head = this.head.getNext();
            this.tail.setNext(this.head);
            return;
        }
        Node p = this.head;
        while (p.getNext() != this.tail) {
            if (p.getNext().getData() == node.getData()) {
                p.setNext(p.getNext().getNext());
            }
            p = p.getNext();
        }
        if (this.tail.getData() == node.getData()) {
            p.setNext(this.head);
            this.tail = p;
        }
    }

    public boolean hasLoop() {
        HashSet<Node> hashSet = new HashSet<>();
        Node p = head;
        while (null != p) {
            if (hashSet.contains(p)) {
                return true;
            }
            hashSet.add(p);
            p = p.getNext();
        }
        return false;
    }

    public void print() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Node p = head;
        while (p.getNext() != head) {
            System.out.print(p.getData()+" ");
            p = p.getNext();
        }
        System.out.print(p.getData());
        System.out.println();
    }

    private class Node {
        private Node next;
        private int data;

        public Node(int data,Node next) {
            this.next = next;
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        CycleLinkedList cll = new CycleLinkedList();
        cll.headInsert(3);
        cll.headInsert(4);
        cll.headInsert(5);
        cll.headInsert(6);
        cll.headInsert(7);
        System.out.println(cll.hasLoop());
        cll.print();
        cll.tailInsert(8);
        cll.tailInsert(9);
        cll.tailInsert(10);
        cll.print();
    }
}
