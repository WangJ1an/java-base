package com.java.base.practice;

import java.nio.ByteBuffer;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by 1 on 2017/3/5.
 */
public class NIOTest {
    void testByteBuffer() {
        ByteBuffer bf = ByteBuffer.allocate(20);
        byte[] orgBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        byte[] newBytes = new byte[10];
        bf.put(orgBytes);
        System.out.println(bf.position());
        System.out.println(bf.limit());
        System.out.println(bf.remaining());
        bf.get(newBytes,0,newBytes.length);
        for (byte b : newBytes) {
//            System.out.println(b);
        }
        for (byte b : bf.array()) {
            System.out.println(b);
        }
        System.out.println(bf.isDirect());
    }

    void fileChannelTest() {
        Path path = FileSystems.getDefault().getPath("iodir","ch.log");
    }

    public static void main(String[] args) {
        new NIOTest().testByteBuffer();
    }
}
