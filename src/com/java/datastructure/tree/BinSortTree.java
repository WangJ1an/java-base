package com.java.datastructure.tree;

import java.util.Stack;

/**
 * Created by 1 on 2017/5/7.
 */
public class BinSortTree {
    private Node root;

    public void insert(int data) {
        Node node = new Node(data);
        if (this.root ==  null) {
            this.root = node;
        } else {
            this.insert(this.root, node);
        }
    }

    private void insert(Node root, Node node) {
        if (root.data == node .data) {
            return;
        }

        if (node.data < root.data) {
            if (root.lchild == null) {
                root.lchild = node;
            } else {
                insert(root.lchild, node);
            }
        } else {
            if (root.rchild == null) {
                root.rchild = node;
            } else {
                insert(root.rchild, node);
            }
        }
    }

    public boolean find(int data) {
        Node node = new Node(data);

        if (find(this.root,node) != null) {
            return true;
        }
        return false;
    }

    private Node find (Node root, Node node) {
        if (root == null) {
            return null;
        }
        if (root.data == node.data) {
            return root;
        }
        if (node.data < root.data) {
            this.parentTemp = root;
            return this.find(root.lchild, node);
        } else {
            this.parentTemp = root;
            return this.find(root.rchild, node);
        }
    }

    //要删除节点的父节点
    private Node parentTemp;
    public boolean delete(int data) {
        Node node = this.find(this.root,new Node(data));
        if (node == null) {
            return false;
        }
        if (null == node.lchild && null == node.rchild) {
            if (parentTemp.lchild == node) {
                parentTemp.lchild = null;
                return true;
            }
            if (parentTemp.rchild == node) {
                parentTemp.rchild = null;
                return true;
            }
        }

        if (null == node.rchild) {
            node.data = node.lchild.data;
            node.lchild = node.lchild.lchild;
            return true;
        }

        if (null == node.lchild) {
            node.data = node.rchild.data;
            node.rchild = node.rchild.rchild;
            return true;
        }

        Node p = node.rchild;
        Node l = node.rchild;
        while (l.lchild != null) {
            p = l;
            l = l.lchild;
        }
        node.data = l.data;
        p.lchild = l.rchild;
        return true;
    }

    public void inOrder() {
        Stack<Node> stack = new Stack<>();
        Node root = this.root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.lchild;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.data+" ");
                root = root.rchild;
            }
        }
        System.out.println();
    }

    private class Node {
        private Node lchild;
        private Node rchild;
        private int data;

        public Node(int data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        BinSortTree bst = new BinSortTree();
        bst.insert(5);
        bst.insert(7);
        bst.insert(9);
        bst.insert(2);
        bst.insert(1);
        bst.insert(4);
        bst.insert(3);
        bst.insert(8);
        bst.insert(6);

        bst.inOrder();
        System.out.println(bst.find(9));
        System.out.println(bst.delete(7));
        bst.inOrder();
    }
}
