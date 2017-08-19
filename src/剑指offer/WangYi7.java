package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by 1 on 2017/8/13.
 */
public class WangYi7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }
        if (arrayList.size() <= 1) {
            System.out.println(0);
            return;
        }
        if (arrayList.size() == 2) {
            System.out.println(arrayList.get(0) - arrayList.get(1));
            return;
        }
        Collections.sort(arrayList);
        int start = 1;
        int end = arrayList.size() - 2;
        int max = arrayList.get(arrayList.size() - 1);
        int min = arrayList.get(0);
        int diff = max - min;

        while (start <= end) {
            int minTemp = arrayList.get(start);
            int maxTemp = arrayList.get(end);
            diff += Math.abs(max - minTemp);
            diff += Math.abs(maxTemp - min);
            max = maxTemp;
            min = minTemp;
            start++;
            end--;
        }
        System.out.println(diff);

    }
}
