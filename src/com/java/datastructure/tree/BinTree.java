package com.java.datastructure.tree;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 1 on 2017/4/17.
 */
public class BinTree {

    private Node root;
    private int index;

    public BinTree() {}

    public BinTree(String source) {
        this.root = this.init(source);
    }

    //字符串的形式初始化二叉树
    private Node init(String source) {
        if (index >= source.length())
            return null;
        char ch = source.charAt(index++);
        if (ch == '#') {
            return null;
        }
        Node node = new Node(ch);
        node.setLchild(init(source));
        node.setRchild(init(source));
        return node;
    }

    //中序线索化
    private Node preNode;
    public void inThread(Node root) {
        if (root == null)
            return;
        inThread(root.getLchild());
        if (root.getLchild() == null) {
            root.setLchild(preNode);
            root.setLtag(true);
        }
        if (preNode.getRchild() == null && preNode != null) {
            preNode.setRchild(root);
            preNode.setRtag(true);
        }
        preNode = root;
        inThread(root.getRchild());
    }

    //前序方式创建树  例如：AB#C##D##
    public Node createBiTree() {
        Scanner in = new Scanner(System.in);
        char ch = in.next().charAt(0);
        if (ch == '#') {
            return null;
        }
        Node node = new Node(ch); //创建根节点
        node.setLchild(createBiTree());
        node.setRchild(createBiTree());
        this.root = node;
        return root;
    }

    //递归前序遍历
    public void preOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData()+" ");
        preOrderTraverse(root.getLchild());
        preOrderTraverse(root.getRchild());
    }

    //递归中序遍历
    public void inOrderTraverse(Node root) {
        if (root == null ) {
            return;
        }
        inOrderTraverse(root.getLchild());
        System.out.print(root.getData()+" ");
        inOrderTraverse(root.getRchild());
    }

    //递归后序遍历
    public void postOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.getLchild());
        postOrderTraverse(root.getRchild());
        System.out.print(root.getData()+" ");
    }

    //非递归方式前中后序遍历
    public void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.getData()+" ");
                stack.push(root);
                root = root.getLchild();
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.getRchild();
            }
        }
    }

    public void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLchild();
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.getData()+" ");
                root = root.getRchild();
            }
        }
    }

    public void postOrder(Node root) {
        Node preNode = null;  //记录之前遍历的右结点
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

           /*左子树一直入栈*/
            while (root != null) {
                stack.push(root);
                root = root.getLchild();
            }
            root = stack.peek();//获得栈顶节点但不出栈

                  /*如果右结点为空，或者右结点之前遍历过，打印根结点*/
            if (root.getRchild() == null || root.getRchild() == preNode) {
                System.out.print(root.getData()+" ");
                preNode = stack.pop();
                root = null;
            } else {
                root = root.getRchild();
            }
        }
    }

    private class Node {
        private Node lchild;
        private Node rchild;
        private boolean rtag;
        private boolean ltag;
        private char data;

        public Node(Node lchild, char data, Node rchild) {
            this.lchild = lchild;
            this.data = data;
            this.rchild = rchild;
        }

        public Node(char data) {
            this.data = data;
        }

        public boolean isRtag() {
            return rtag;
        }

        public void setRtag(boolean rtag) {
            this.rtag = rtag;
        }

        public boolean isLtag() {
            return ltag;
        }

        public void setLtag(boolean ltag) {
            this.ltag = ltag;
        }

        public char getData() {
            return this.data;
        }

        public Node getLchild() {
            return this.lchild;
        }

        public Node getRchild() {
            return this.rchild;
        }

        public void setData(char data) {
            this.data = data;
        }

        public void setLchild(Node node) {
            this.lchild = node;
        }

        public void setRchild(Node node) {
            this.rchild = node;
        }
    }

    public static void main(String[] args) {
        BinTree binTree = new BinTree("ABD###C#EF###");
        BinTree.Node root = binTree.root;
        System.out.println("递归遍历：");
        binTree.preOrderTraverse(root);
        System.out.println();
        binTree.inOrderTraverse(root);
        System.out.println();
        binTree.postOrderTraverse(root);
        System.out.println("\n"+"非递归遍历：");
        binTree.preOrder(root);
        System.out.println();
        binTree.inOrder(root);
        System.out.println();
        binTree.postOrder(root);
    }
}