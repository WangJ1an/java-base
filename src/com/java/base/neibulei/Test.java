package com.java.base.neibulei;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by 1 on 2017/1/26.
 */
public class Test {
    public static Inter function(){
        return new Inter(){
            public void method(){
                System.out.println("1");
            }
        };
    }
}
