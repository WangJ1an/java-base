package com.java.base.string;

/**
 * Created by 1 on 2017/2/25.
 */
public class StringTest1 {
    public static void main(String[] args) {
        String s1 = "qwecastertdsaloverrdsfds";
        String s2 = "asdcastfghloverr";
        String maxSubString = maxSubString(s1,s2);
        System.out.println("maxSubString: "+maxSubString);

    }

    public static String maxSubString(String s1, String s2) {
        String max,min;
        //明确哪个字符串是长串
        max = s1.length() > s2.length() ? s1 : s2;
        min = max.equals(s1) ? s2 : s1;
            for (int i = 0; i < min.length(); i++) {
                for (int start = 0, end = min.length() - i; end <= min.length(); start++, end++) {
                    String temp = min.substring(start, end);
                    if (max.contains(temp)) {
                        return temp;
                    }
                }
            }
        return null;
    }
}
