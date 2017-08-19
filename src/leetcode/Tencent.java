package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 1 on 2017/7/25.
 */
public class Tencent {
    /*
        2.接收以屏幕输入的长度为16字节整数倍的字符串，回车后，按示例样式排版输出
        例：
        输入
         abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl
        
        输出
        16进制偏移                                16进制表示（一行16个字符）
        0000 0000 61 62 63 64 65 66 67 68          69 6a 6b 6c 6d 6e 6f 70
        0000 0010 71 72 73 74 75 76 77 78          79 7a 61 62 63 64 65 66
        0000 0020 67 68 69 6a 6b 6c 6d 6e          6f 70 71 72 73 74 75 76
        0000 0030 77 78 79 7a 61 62 63 64          65 66 67 68 69 6a 6b 6c
        正文
        abcdefghijklmnop
        qrstuvwxyzabcdef
        ghijklmnopqrstuv
        wxyzabcdefghijkl 
    **/
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            char[] chars = string.toCharArray();
            int n = 16;
            int count = 0;
            ArrayList<String> arrayList = new ArrayList<>();
            while (n <= chars.length) {
                StringBuilder sb0 = new StringBuilder();
                StringBuilder sb = new StringBuilder();
                for (int i = count*16; i < n; i++) {
                    char ch = chars[i];
                    sb0.append(ch);
                    String x = trans16(ch);
                    sb.append(x).append(" ");
                    if ((i + 1) % 8 == 0) {
                        sb.append(" ");
                    }
                }
                arrayList.add(sb.toString()+sb0);
                count++;
                n = 16*(count+1);
            }
            for (int i = 0; i < arrayList.size(); i++) {
                String str = arrayList.get(i);
                System.out.println(str);
            }
        }

    }

    private static String trans16(char ch) {

      return Integer.toHexString(ch);

    }
    
}
