package leetcode;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by 1 on 2017/8/11.
 */
public class ConstructQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int num = scanner.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = num; i > 0; i--) {
                list.addFirst(i);
                int temp = list.removeLast();
                list.addFirst(temp);
            }
            while (!list.isEmpty()) {
                if (list.size() == 1) {
                    System.out.print(list.remove()+"\r\n");
                } else {
                    System.out.print(list.removeFirst() + " ");
                }
            }
        }
    }
}
