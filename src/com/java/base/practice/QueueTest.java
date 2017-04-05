package com.java.base.practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by 1 on 2017/3/4.
 */
public class QueueTest {
    void testDeque() {
        ArrayDeque<String> ad = new ArrayDeque<String>();
        ad.addFirst("a");
        ad.addFirst("b");
        ad.addLast("c");
        ad.addFirst("d");
        ad.addFirst("e");
        dump(ad.iterator());
        System.out.println(ad.element());
        System.out.println(ad.getFirst());
    }

    void testPriorityQueue() {
        PriorityQueue<String> pq = new PriorityQueue<String>();
        pq.add("d");
        pq.add("c");
        pq.add("b");
        pq.add("e");
        System.out.println(pq.peek());
        System.out.println(pq.offer("haha"));
        System.out.println(pq.offer("o"));
        dump(pq.iterator());
        Arrays.sort(pq.toArray());
        System.out.println();
        dump(pq.iterator());
    }

    <T> void dump(Iterator<T> it){
        while (it.hasNext()) {
            System.out.print("[");
            System.out.print(it.next());
            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        //优先级队列PriorityQueue与双端队列Deque测试，方法调用参考API文档
        //new QueueTest().testDeque();
        new QueueTest().testPriorityQueue();
    }
}
