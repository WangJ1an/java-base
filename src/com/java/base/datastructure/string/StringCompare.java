package com.java.base.datastructure.string;

/**
 * Created by 1 on 2017/4/4.
 */

/*
* '0' = 48
* 'A' = 65
* 'a' = 97
*/

public class StringCompare {

    public static int compare(String str1, String str2) {
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int len1 = str1.length();
        int len2 = str2.length();
        int min = len1;

        if (len2 < len1) {
            min = len2;
        }

        for (int i = 0; i < min - 1; i++) {
            if (char1[i] != char2[i]) {
                return char1[i] - char2[i];
            }
        }
        return len1 - len2;
    }

    public static String replace(String str, String substr, String rep) {
        int key = findKey(str, substr);
        char[] cstr = str.toCharArray();
        char[] crep = rep.toCharArray();
        for (int i = 0; i < crep.length; i++) {
            cstr[key++] = crep[i];
        }
        return String.valueOf(cstr);
    }

    public static int findKey(String str, String substr) {
        for (int i = 0; i < str.length(); i++) {
            int k = i;
            int j;
            for (j = 0; j < substr.length() && i < str.length();) {
                if (str.charAt(i) == substr.charAt(j)) {
                    if (substr.charAt(0) == str.charAt(i)) {
                        k = i;
                    }
                    i++;
                    j++;
                } else {
                    break;
                }
            }
            if (j == substr.length()) {
                return k;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "abcabcabc";
        String str2 = "abcabx";

        System.out.println(StringCompare.findKey(str1,str2));
    }
}
