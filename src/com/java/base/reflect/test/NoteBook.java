package com.java.base.reflect.test;

/**
 * Created by 1 on 2017/3/13.
 */
public class NoteBook {

    public NoteBook() {}

    public void run() {
        System.out.println("NoteBook run");
    }

    public void useUSB(USB usb) {
        usb.open();
        usb.close();
    }
}
