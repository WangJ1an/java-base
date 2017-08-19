package 剑指offer;

import java.util.Scanner;

/**
 * Created by 1 on 2017/8/12.
 */
public class wangyi1 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int arr[] = new int[n];
// 读取数组
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
//操作n次后,前半段是数列中的奇数下标的数，后半段是偶数下标的数，只要按顺序输出前半段和后半段即可
            for (int i = n - 1; i >= 0; i -= 2) {
                System.out.print(arr[i] + " ");//输出奇数下标的数
            }
            for (int i = n % 2; i < n; i += 2) {//0->2
                if (i == n - 2)//最后一个元素后面空格
                    System.out.print(arr[i]);
                else
                    System.out.print(arr[i] + " ");
            }
        }
}
