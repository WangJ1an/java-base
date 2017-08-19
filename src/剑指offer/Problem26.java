package 剑指offer;

/**
 * Created by 1 on 2017/8/17.
 */
public class Problem26 {
    /**
     * 写一个函数，求两个整数之和，
     * 要求在函数体内不得使用+、-、*、/四则运算符号。
     * 通过异或求和，和与求进位的方式
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        int sum = 0;
        while (num2 != 0) {
            sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return sum;
    }
}
