package leetcode;

import java.util.Scanner;

/**
 * Created by 1 on 2017/4/27.
 */
public class HuiWenString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s1 = scan.next();
            System.out.println(method(s1));
        }
    }
    
    public static int method(String s1) {
        String s2 = new StringBuffer(s1).reverse().toString();
        if (s1.equals(s2)) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            for (int j = i; j < s2.length(); j++) {
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    count++;
                    break;
                }
            }
        }
        return s1.length()-count;
    }
}
