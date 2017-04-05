package com.java.base;

import java.util.Scanner;

/**
 * Created by 1 on 2017/2/5.
 */
/*
    对于二进制加法运算，若不考虑进位，则1+1=0,1+0=1，0+1=1,0+0=0，通过对比异或，
不难发现，此方法与异或类似。因而排除进位，加法可以用异或来实现。然后考虑进
位，0+0的进位为0,1+0的进位为0，只用1+1的进位为1，该操作与位运算的&操作类似。
那么加法运算可以这样实现：
1）先不考虑进位，按位计算各位累加（用异或实现），得a;
2）然后计算进位，并将进位的值左移，得值b,若b为0，则a就是加法运算的结果；
   若b不为0，则a+b即得结果（递归调用该函数）。
* */
public class Sum {
    static int Sum(int num1,int num2){
        int sum,carry;
        sum=num1^num2;
        carry=(num1&num2)<<1;
        if (carry == 0)
            return sum;
        return Sum(sum,carry);
    }

    static void fun(int []arry){
        int temp;
        for(int i=0;i<arry.length-1;i++){
            for(int j=i+1;j<arry.length;j++){
                    if(arry[i]==0){
                        temp=arry[i];
                        arry[i]=arry[j];
                        arry[j]=temp;
                    }
            }
        }
        for(int n:arry){
            System.out.print(n+" ");
        }
    }

    public static void main(String []args) {
        int[] num = {1, 4, 6, 7, 8};
        int target = 8;
        for (int i = 0; i < num.length - 1; i++) {
            for(int j = i+1; j < num.length; j++){
                if (num[i]+num[j] == target)
                    System.out.println("["+i+","+j+"]");
            }
        }
    }
}

