package leetcode;

import java.util.Scanner;

/**
 * Created by 1 on 2017/8/3.
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(get(num));
        }

    }

    public static int get(int num) {
        if (num < 1) {
            return 0;
        }

        if (num > 6) {
            return 0;
        }
        
        int temp = 1;
        for (int i = 1; i < num; i++) {
            temp += get(i);
        }
        return temp;
    }

}
