package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by 1 on 2017/4/2.
 */
public class CycleWord {
    /*
    * 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。
    * 例如：picture 和 turepic 就是属于同一种循环单词。
     * 现在给出n个单词，需要统计这个n个单词中有多少种循环单词
    * */

    public static String move(String string) {
        char[] chars = string.toCharArray();
        char[] charTemp = new char[string.length()];

        for (int i = 0,j = 0; i < chars.length - 1; j++, i++) {
            charTemp[j] = chars[i+1];
        }
        charTemp[chars.length - 1] = chars[0];
        return String.valueOf(charTemp);
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(str = move(str));
        System.out.println(move(str));
    }
}
