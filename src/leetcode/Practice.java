package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by 1 on 2017/4/11.
 */
public class Practice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        while (in.hasNext()) {
            strings.add(in.nextLine());
            Iterator<String> it = strings.iterator();
            String string = null;
            while (it.hasNext()) {
                string = it.next();
                it.remove();
                String[] numbers = string.split(" ");
                int min = Integer.parseInt(numbers[0]);
                int max = Integer.parseInt(numbers[1]);
                sumMethod(min,max);
            }
        }

    }

    private static void sumMethod(int firstNumber, int n) {
        double sum = firstNumber;
        double temp = firstNumber;
        for (int i = 0; i < n - 1; i++) {
            temp = Math.sqrt(temp);
            sum += temp;
        }
        System.out.printf("%.2f\n",sum);
    }

    private static void findMethod(int min, int max) {
        int count = 0;
        for (int i = min; i <= max ; i++) {
            int x = i%10;
            int xx = (i/10)%10;
            int xxx = i/100;
            if (x*x*x+xx*xx*xx+xxx*xxx*xxx == i) {
                System.out.print(i+" ");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("no");
        }
        System.out.println();
    }
}
