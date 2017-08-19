package 剑指offer;

import java.util.Scanner;

/**
 * Created by 1 on 2017/8/13.
 */
public class WangYi3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sum += num;
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        double key = n * (min + max) / 2;
        if (key == sum) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}
