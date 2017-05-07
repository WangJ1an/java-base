package com.java.datastructure;


/**
 * Created by 1 on 2017/3/11.
 */
//线性表----链式存储
public class MyLinkedList {

    private Node head;

    public MyLinkedList(){}

    public MyLinkedList(Node head) {
        this.head = head;
    }

    public void insert(int data) {
        Node node = new Node(data,null);

        if (null == this.head) {
            this.head = node;
            return;
        }
        if (this.head.getData() > data) {
            node.setNext(this.head);
            this.head = node;
            return;
        }
        Node p = this.head;
        while (null != p.getNext()) {
            if (p.getNext().getData() >= data) {
                break;
            }
            p = p.getNext();
        }
        node.setNext(p.getNext());
        p.setNext(node);
    }

    public void headInsert(int data) {
        Node node = new Node(data,null);
        if (null == this.head) {
            this.head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }

    public void remove(int data) {
        if (null == this.head) {
            System.out.println("空链表");
            return;
        }
        if (this.head.getData() == data) {
            this.head = this.head.getNext();
            return;
        }
        Node p = this.head;
        //定义node 存储链表中值为需要被删除的节点，即data的节点
        Node node = null;
        while (null != p) {
            if (null != p.getNext() && p.getNext().getData() == data) {
                node = p.getNext();
                break;
            }
            p = p.getNext();
        }
        if (p == null) {
            System.out.println("没有该元素");
            return;
        }
        p.setNext(node.getNext());
    }

    public Node mergeAll(Node head1, Node head2) {
        Node node = null;
        Node newhead = null;
        Node tail = null;
        while (null != head1 && null != head2) {
            if (head1.getData() < head2.getData()) {
                node = head1;
                head1 = head1.getNext();
            } else {
                node = head2;
                head2 = head2.getNext();
            }
            node.setNext(null);
            if (null == newhead) {
                newhead = node;
            } else {
                tail.setNext(node);
            }
            tail = node;
        }
        if (null != head1) {
            tail.setNext(head1);
        }
        if (null != head2) {
            tail.setNext(head2);
        }
        return newhead;
    }

    public void addAll(MyLinkedList linkedList) {
        if (linkedList.isNull())
            return;
        Node p = linkedList.head;
        while (p != null) {
            this.insert(p.getData());
            p = p.getNext();
        }
    }

    public void reverse() {
        Node newhead = null;
        Node p = null;
        while (null != head) {
            p = head.getNext();
            head.setNext(newhead);
            newhead = head;
            head = p;
        }
        head = newhead;
    }

   /*判断是否有环
    public boolean hasLoop() {
        Node p = this.head;
        HashSet<Node> hs = new HashSet<>();
        while (null != p){
            if (hs.contains(p)) {
                return true;
            }
            hs.add(p);
            p = p.getNext();
        }
        return false;
    }*/

    public boolean hasLoop() {
        Node fast = head;
        Node slow = head;
        if (head.getNext() == null || head == null) {
            return false;
        }
        while(null != fast && null != fast.getNext()) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean isNull() {
        if (this.head == null)
            return true;
        else
            return false;
    }

    public void print() {
        if (null == this.head) {
            return;
        }
        Node p = this.head;
        while (null != p) {
            System.out.print(p.getData()+"  ");
            p = p.getNext();
        }
        System.out.println();
    }

    public static void testLoop() {
        MyLinkedList list = new MyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.head.getNext().getNext().setNext(list.head);
        System.out.println(list.hasLoop());
    }

    //节点类
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
        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.insert(2);
        linkedList1.insert(4);
        linkedList1.insert(6);
        linkedList1.insert(8);
        linkedList1.insert(7);
        linkedList1.insert(10);
        linkedList1.insert(9);
        linkedList1.print();
        linkedList1.remove(7);
        linkedList1.print();
        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.insert(1);
        linkedList2.insert(3);
        linkedList2.insert(5);
        linkedList2.print();
        Node node = linkedList1.mergeAll(linkedList1.head,linkedList2.head);
        MyLinkedList linkedList3 = new MyLinkedList(node);
        linkedList3.print();

//        linkedList1.addAll(linkedList2);
//        linkedList1.print();
//        linkedList1.reverse();
//        linkedList1.print();
//        System.out.println(linkedList1.hasLoop());
    }
}
