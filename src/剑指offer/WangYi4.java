package 剑指offer;

import java.util.Scanner;

/**
 * Created by 1 on 2017/8/13.
 */
public class WangYi4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            int sum = 1;
            int prekey = chars[0];
            int max = 0;
            for (int i = 1; i < chars.length; i++) {
                char ch = chars[i];
                if (ch != prekey) {
                    sum++;
                } else {
                    if (sum > max) {
                        max = sum;
                        sum = 1;
                    } else {
                        sum = 1;
                    }
                }
                prekey = ch;
            }
            if (sum > max) {
                max = sum;
            }
            System.out.println(max);
        }
    }
}
