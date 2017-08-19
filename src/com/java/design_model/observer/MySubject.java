package com.java.design_model.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 1 on 2017/8/6.
 */
public class MySubject {
    private List<BaseObserver> junshi = new ArrayList<>();
    private List<BaseObserver> yule = new ArrayList<>();
    private List<BaseObserver> tiyu = new ArrayList<>();
    private ConcurrentHashMap<String,List<BaseObserver>> hashMap = new ConcurrentHashMap<>();

    public MySubject() {
        hashMap.put("军事",junshi);
        hashMap.put("娱乐",yule);
        hashMap.put("体育",tiyu);
    }

    public void attach(String str, BaseObserver observer) {
        List<BaseObserver> list = checkTopic(str);
        list.add(observer);
    }

    private void notifyAllObserver(String leibie, String str) {
        List<BaseObserver> list = checkTopic(leibie);
        for (BaseObserver o :
                list) {
            o.update(str);
        }
    }

    public void addTopic(String leibie, String str) {
        notifyAllObserver(leibie,str);
    }

    private List<BaseObserver> checkTopic(String str) {
        return this.hashMap.get(str);
    }
}
