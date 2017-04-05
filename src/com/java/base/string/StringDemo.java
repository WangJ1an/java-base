package com.java.base.string;

/**
 * Created by 1 on 2017/2/21.
 */
public class StringDemo {
    public static void main(String[] args){
        String str = "itcast_ch";
        //fun(str);
        int[] arry = {23,43,10,50};
        System.out.println(toString(arry));

    }

    public static String toString(int[] arry){
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0;i < arry.length;i++){
            if (i != arry.length - 1)
                sb.append(arry[i]+",");
            else if (i == arry.length - 1)
                sb.append(arry[i]+"]");
        }
        return sb.toString();
    }

    public static void fun(String str) {
        for (int x = 0;x < str.length();x++){
            for (int y = 0,z = str.length()-x;z <=str.length();z++,y++){
                String tmp = str.substring(y,z);
                System.out.println(tmp);
            }
        }
    }
}
