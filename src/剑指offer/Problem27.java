package 剑指offer;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/18.
 */
public class Problem27 {
    /**
     * 题目描述
     将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     数值为0或者字符串不是一个合法的数值则返回0
     输入描述:
     输入一个字符串,包括数字字母符号,可以为空
     输出描述:
     如果是合法的数值表达则返回该数字，否则返回0
     示例1
     输入

     +2147483647
     1a33
     输出

     2147483647
     0

     //1.字符串为空
     //2.只有一个正或负号
     //3.整数上下溢出 Integer.MAX_VALUE (2^31-1)  Integer.MIN_VALUE(-2^31)
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int i = 0;
        int flag = 0;
        int len = str.length() - 1;
        if (str.charAt(0) == '+') {
            i = 1;
        } else if (str.charAt(0) == '-') {
            flag = -1;
            i = 1;
        }
        int sum = 0;
        for (; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ('0' <= ch && ch <= '9') {
                int n = ch - '0';
                if ( flag == -1) {
                    sum += n * Math.pow(10,len - i) * -1;
                } else {
                    sum += n * Math.pow(10,len - i);
                }
            } else {
                flag = -2;
            }
        }
        if (flag == -2) {
            return 0;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(StrToInt("-2147483648"));
    }
}
