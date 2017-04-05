package com.java.base.exception;

/**
 * Created by 1 on 2017/1/19.
 */
public class ExceptionTest {
    public static int div(int a,int b) {
        if (b < 0)
            throw new FuShuException("除负数了");
        else
            return a / b;
    }
    public static void main(String []args){

        int a = div(2,-1);
        System.out.println(a);
        System.out.println("over");
    }
}

class FuShuException extends RuntimeException{    //运行时异常
    FuShuException(String Message){
        super(Message);
    }
}
