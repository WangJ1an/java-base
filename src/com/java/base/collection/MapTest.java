package com.java.base.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by 1 on 2017/3/6.
 */
public class MapTest {
    public static void main(String[] args) {
        String str = "adsafe=[]Fg][Dddfjkxdas234ljiow";

        str = getCharCount(str);

        System.out.println(str);
    }

    public static String getCharCount(String str) {
        char[] chs = str.toCharArray();

        TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();

        for (int i = 0; i < chs.length; i++) {
            if (!(chs[i] >= 'a' && chs[i] <= 'z' ||chs[i] >= 'A' && chs[i] <= 'Z')) {
                continue;
            }
            Integer value = map.get(chs[i]);

            if (value == null) {
                map.put(chs[i],1);
            } else {
                value++;

                map.put(chs[i],value);
            }
        }
        return mapToString(map);
    }

    private static String mapToString(Map<Character,Integer> map) {
        StringBuilder sb = new StringBuilder();

        for (Character key : map.keySet()) {
            Integer value = map.get(key);
            sb.append(key+"("+value+")");
        }
        return sb.toString();
    }
}
