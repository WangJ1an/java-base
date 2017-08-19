package leetcode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 1 on 2017/8/11.
 */
public class Shuffle {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); //T组数据
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[2 * n];
            for (int i = 1; i <= 2 * n; i++) { //数据从1开始，取到2n
                int index = i; //因为下面的while循环要多次改变i值，所以用index去替代i
                for (int j = 0; j < k; j++) {//翻转k次
                    if (index <= n) {
                        index = 2 * index - 1;
                    } else {
                        index = (index - n) * 2;
                    }
                }
                arr[index - 1] = sc.nextInt(); //放入数组
            }
            //输出
            int i;
            for (i = 0; i < 2 * n - 1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr[i]);
        }
    }
}
