package com.java.base.file;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by 1 on 2017/3/7.
 */
public class GetAllFiles2 {
    public static void main(String[] args) {
        /*
        * 遍历文件夹，不用递归。
        * */
        File file = new File("D:\\workspace\\java-base\\src\\com\\java\\base");
        File[] files = file.listFiles();
        Queue<File> queue = new Queue<File>();
        for (File f:files) {
            if (f.isDirectory()) {
                queue.add(f);
            } else {
                System.out.println(f.getName());
            }
        }
        while (!queue.isNull()) {
            File subDir = queue.get();//从队列中取出子目录
            System.out.println(subDir.getName());
            File[] subFiles = subDir.listFiles();
            for (File f : subFiles) {
                if (f.isDirectory()) {
                    queue.add(f);
                } else {
                    System.out.println(f.getName());
                }
            }
        }
    }
}

class Queue <E>{
    private LinkedList<E> linkedList;

    public Queue() {
        linkedList = new LinkedList<E>();
    }
    public void add(E e) {
        linkedList.addFirst(e);
    }

    public E get() {
        return linkedList.removeLast();
    }

    public boolean isNull() {
        return linkedList.isEmpty();
    }
}
