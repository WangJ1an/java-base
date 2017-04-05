package com.java.base.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by 1 on 2017/3/4.
 */
public class MapTest {
    void testHashMap() {
        HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
        hashMap.put(0,"haha");
        hashMap.put(1,"java");
        hashMap.put(2,"xixi");

        System.out.println(hashMap.size());

        System.out.println(hashMap.get(1));

        System.out.println(hashMap.containsKey(1));

        System.out.println(hashMap.containsValue("xx"));

        System.out.println(hashMap);//此处等于hashMap.toString

        System.out.println(hashMap.clone());

//        dumpHashMap(hashMap);
    }
    static<T> void dumpHashMap(HashMap<T,T> hashMap) {

        Set<Map.Entry<T, T>> set = hashMap.entrySet();
        Iterator<Map.Entry<T, T>> it = set.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

    public static void main(String[] args) {
//        new MapTest().testHashMap();
        int[] datas = new int[]{37,21,13,9};
        int[] temp = new int[datas.length];
        int m = datas.length;
        for (int i = 0; i < m; i++) {
            int index = hash(datas[i],m);
            int j = 0;
            while (temp[index] != 0) {
                j++;
                index = hash(datas[i] + j, m);
            }
            temp[index] = datas[i];
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.println(i+":   "+temp[i]);
        }
        System.out.println(getIndex(temp,21));
    }

    static int getIndex(int[] datas, int key) {
        int index = hash(key,datas.length);
        int temp = index;
        int j = 0;
        if (datas[index] == key)
            return index;
        while (datas[index] != key) {
            j++;
            index = hash(key + j, datas.length);
            if (datas[index] == key) {
                return index;
            } else if (temp == index) {
                break;
            }
        }
        return -1;
    }

    static int hash(int num, int m) {
        return num%m;
    }
}
