package com.java.base.duotai;

/**
 * Created by 1 on 2017/1/17.
 */
public class NetCard implements PCI{
    @Override
    public void open(){
        System.out.println("NetCard is run");
    }

    @Override
    public void close(){
        System.out.println("NetCard is close");
    }

}
