package com.java.base.exception;

/**
 * Created by 1 on 2017/2/3.
 */
public class ZiFuTest {
    class AException extends Exception{}

    class BException extends AException{}

    class CException extends Exception{}

    class Fu {
        void function() throws AException {}
    }

    class Zi extends Fu {
        void function() throws BException{}
    }

    public static void main(String []args){

    }
}
