package com.java.base.datastructure.rpntest;


/**
 * Created by 1 on 2017/3/26.
 */

//逆波兰式( Reverse Polish Notation, RPN)
public class RPNTest {

    public static void main(String[] args) {
        String str = "10+15-5+(4+10)/7";
        System.out.println(RPN.polish(str));
        System.out.println(RPN.calculate(RPN.polish(str)));

    }
}
