package 剑指offer;

import java.util.Scanner;

/**
 * Created by 1 on 2017/8/13.
 */
public class WangYi5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int days = 0;
        if (f > d / x) {
            days = d / x;
        } else {
            days = f + (d - f * x) / (p + x);
        }

        /*else {
            while (d >= p + x) {
                if (f != 0) {
                    f--;
                } else {
                    d -= p;
                }
                d -= x;
                days++;
            }*/
        System.out.println(days);
    }
}
