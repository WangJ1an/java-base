package com.java.base.collection;

import java.util.LinkedList;

/**
 * Created by 1 on 2017/2/27.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        Queue queue = new Queue(link);
        queue.myAdd("abc1");
        queue.myAdd("abc2");
        queue.myAdd("abc3");

        Stack stack = new Stack(link);
        stack.myAdd("abc1");
        stack.myAdd("abc2");
        stack.myAdd("abc3");

        while (!stack.myEmpty()) {
            System.out.println(stack.myGet());
        }

       // while (!queue.myEmpty()) {
         //   System.out.println(queue.myGet());
        //}
    }
}

class Queue {
    private LinkedList link;
    public Queue(LinkedList link) {
        this.link = link;
    }

    public void myAdd(Object o) {
        link.addFirst(o);
    }

    public Object myGet(){
        return link.removeLast();
    }

    public boolean myEmpty() {
        return link.isEmpty();
    }
}

class Stack {
    private LinkedList link;

    public Stack(LinkedList link) {
        this.link = link;
    }

    public void myAdd(Object object) {
        link.addFirst(object);
    }

    public Object myGet() {
        return link.removeFirst();
    }

    public boolean myEmpty() {
        return link.isEmpty();
    }
}
