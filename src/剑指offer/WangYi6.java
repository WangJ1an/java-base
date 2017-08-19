package 剑指offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 1 on 2017/8/13.
 */
public class WangYi6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y[i] = sc.nextInt();
            }

            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(0);
            for (int i = 1; i <= n; i++) {
                int left = 0;
                int right = 0;
                for (int j = 0; j < x.length; j++) {
                    if (x[j] < x[i]) {
                        left++;
                    }
                }
            }
        }
    }
}
