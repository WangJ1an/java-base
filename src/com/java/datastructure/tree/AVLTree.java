package com.java.datastructure.tree;

/**
 * Created by 1 on 2017/5/20.
 */
public class AVLTree <T extends Comparable<T>> {

    private void turnRight(Node p) {

        Node node = p.left;
        p.left = node.right;
        node.right = p;

    }

    private void turnLeft(Node p) {

        Node node = p.right;
        p.right = node.left;
        node.left = p;

    }

    private class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data ) {
            this.data = data;
        }
    }
}
