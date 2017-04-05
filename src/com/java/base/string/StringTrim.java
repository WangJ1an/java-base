package com.java.base.string;

/**
 * Created by 1 on 2017/2/25.
 */
public class StringTrim {
    public static void main(String[] args) {
        String str = " abcdef ";
        System.out.println(myTrim(str));
    }

    public static String myTrim(String string) {
        int start = 0;
        int end = string.length() - 1;
        while (start <= end && string.charAt(start) == ' '){
            start++;
        }
        while (start <= end && string.charAt(end) == ' '){
            end--;
        }
        return string.substring(start,end);
    }
}
