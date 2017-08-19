package com.java.design_model.observer;

/**
 * Created by 1 on 2017/8/6.
 */
public class MyObserver implements BaseObserver {
    private String name;

    public MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String str) {
        System.out.println(this.name+"----订阅到消息----"+str);
    }

    public static void main(String[] args) {
        MySubject subject = new MySubject();
        MyObserver observer1 = new MyObserver("军事迷");
        MyObserver observer2 = new MyObserver("追星族");
        subject.attach("军事",observer1);
        subject.attach("娱乐",observer2);
        subject.addTopic("军事","中印冲突");
        subject.addTopic("娱乐","马蓉");
    }
}
