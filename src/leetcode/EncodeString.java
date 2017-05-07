package leetcode;

import java.util.Scanner;

/**
 * Created by 1 on 2017/4/27.
 */
public class EncodeString {
    /*
    * 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。
    * 比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。
        输入描述:

        每个测试输入包含1个测试用例
        每个测试用例输入只有一行字符串，字符串只包括大写英文字母，长度不超过10000。


        输出描述:

        输出编码后的字符串

        输入例子:

        AAAABCCDAA

        输出例子:

        4A1B2C1D2A
    *
    *
    * */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        System.out.println(codeString(string));
    }

    public static String codeString(String str) {
        if (str.length() == 1) {
            return "1"+str;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length;) {
            char preChar = chars[i];
            int count = 1;
            while (++i != chars.length) {
                char ch = chars[i];
                if (ch == preChar) {
                    count++;
                } else {
                    sb.append(count).append(preChar);
                    break;
                }

                if (i == chars.length - 1) {
                    sb.append(count).append(preChar);
                }
            }

            if (i == chars.length - 1) {
                sb.append(1).append(chars[i]);
            }

        }
        return sb.toString();
    }

}
