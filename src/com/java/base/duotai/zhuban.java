package com.java.base.duotai;

/**
 * Created by 1 on 2017/1/17.
 */
public class zhuban{
    public void run(){
        System.out.println("maincard is run");
    }
    //接口型引用指向自己的子类对象；
    public void usepci(PCI pci){
        pci.open();
        pci.close();
    }
}
