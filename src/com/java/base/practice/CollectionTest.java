package com.java.base.practice;

import com.java.base.Student;

import java.util.*;
import java.util.List;

/**
 * Created by 1 on 2017/3/4.
 */
public class CollectionTest {
    //测试链表
    void testLinkedList() {
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.push(4);
        list2.push(7);
        list2.push(8);
    }
    //测试哈希集
    void testHashSet() {
        HashSet<String> hs = new HashSet<String>();
        hs.add("c");
        hs.add("c");
        hs.add("a");
        hs.add("d");
        System.out.println(hs);
        Iterator<String> it = hs.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }
    //测试树集，注意树集的排序方式Comparable接口（自然排序）；Comparator接口（比较器）
    void testTreeSet() {
//树集保证元素唯一性的方式依赖于对象比较方法，即compareTo或compare方法，若返回值为0则为同一对象
        TreeSet<Student> tree1 = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int temp = o2.getAge() - o1.getAge();
                return temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
            }
        });
        tree1.add(new Student("小明1",20));
        tree1.add(new Student("小明4",20));
        tree1.add(new Student("小明3",24));
        tree1.add(new Student("小明2",19));
        System.out.println(tree1);
        dump(tree1.iterator());
    }
    void testArrayList() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("haha");
        al.add("hehe");
        al.add("xixi");
        System.out.println(al.toString());
    }

    <T> void dump(Iterator<T> iterator) {
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    void Vector() {
        Vector<String> vector = new Vector<String>();
//        向vector里添加元素
        for (int i = 0; i < 10; i++) {
            vector.add(String.valueOf(i));
        }

        dump(vector.iterator());
        // 截取截头不截尾
        List<String> subVector = vector.subList(2,5);

        System.out.println("-----------------------");
        //用迭代器遍历subVector 并删除其中的元素，对其的更改会反映在vector中
        for (Iterator<String> it = subVector.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
            it.remove();
        }

        System.out.println("-----------------------");
        //vector中少了 2-4号元素
        dump(vector.iterator());
    }
    public static void main(String[] args) {
        new CollectionTest().Vector();
    }
}