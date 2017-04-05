package com.java.base.fanxing;

import java.util.List;

/**
 * Created by 1 on 2017/1/20.
 */
public class FindMaxValue {
    public static<T> T findMaxValue(List<T> values,Compare compare){
        if(null == values || 0 == values.size()){
            return null;
        }
        T max =  values.get(0);
        for (T value:values){
            if(!compare.compare(max,value)){
                max = value;
            }
        }
        return max;
    }
}
