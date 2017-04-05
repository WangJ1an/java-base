package com.java.base.datastructure;

/**
 * Created by pengfei on 2017/3/8.
 */
public class Hash {

    private static final int[] inputs = new int[] {
            32,
            21,
            75,
            13,
            7,
            37,
    };

    public static void main(String[] args) {
        Node[] nodes = new Node[6];

        for(int i = 0; i < inputs.length; ++i) {
            Node node = new Node(inputs[i], null);

            int index = hash(inputs[i], inputs.length);

            if(null == nodes[index]) {
                nodes[index] = node;
                continue;
            }
            Node head = nodes[index];
            while(null != head.getNext()) {
                head = head.getNext();
            }
            head.setNext(node);
        }

        for(int i = 0; i < nodes.length; ++i) {
            Node head = nodes[i];
            if(null == head) {
                continue;
            }
            while(null != head) {
                System.out.print(head.getData() + " ");
                head = head.getNext();
            }
        }
        System.out.println();
    }

    private static int hash(int key, int length) {
        return key % length;
    }

}

class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }
}
