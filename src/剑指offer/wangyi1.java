package 剑指offer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 1 on 2017/8/12.
 */
public class wangyi1 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {

                arrayList.add(sc.nextInt());
                int temp = 0;
                for (int index0 = 0,index1 = arrayList.size() - 1; index0 < index1;) {
                    temp = arrayList.get(index0);
                    arrayList.set(index0,arrayList.get(index1));
                    arrayList.set(index1,temp);
                    index0++;
                    index1--;
                }
            }

            for (int i = 0; i < arrayList.size(); i++) {
                if (i == n-1) {
                    System.out.print(arrayList.get(i));
                } else {
                    System.out.print(arrayList.get(i)+ " ");
                }
            }
        }
}
