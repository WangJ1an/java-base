package com.java.datastructure;

/**
 * Created by 1 on 2017/3/26.
 */
public class DiGuiTest {
    //将数字逆序输出
    public static int test(int data) {
        int n = data % 10;

        if (data == 0) {
            return 0;
        }

        String str = String.valueOf(data);
        int x = str.length();

        return (int) (n * Math.pow(10,x-1) + test(data/10));
    }

    public static void main(String[] args) {
        System.out.println(test(13579));
    }
}
