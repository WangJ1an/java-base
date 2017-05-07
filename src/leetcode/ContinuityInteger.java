package leetcode;

import java.util.*;

/**
 * Created by 1 on 2017/4/6.
 */
public class ContinuityInteger {
    /*
    * 牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。
    * 牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如：
    *  10 7 12 8 11 那么抹除掉的整数只可能是9
    *  5 6 7 8 那么抹除掉的整数可能是4也可能是9
    *
    * */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.valueOf(in.next()));
        }
        ArrayList arrayList = method(treeSet);
        if (arrayList.size() == 1) {
            System.out.println(arrayList.get(0));
        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i == arrayList.size() - 1) {
                    System.out.print(arrayList.get(i));
                    break;
                }
                System.out.print(arrayList.get(i)+" ");
            }
        }
    }

    public static ArrayList method(TreeSet<Integer> treeSet) {
        Iterator<Integer> it = treeSet.iterator();
        int[] numbers = new int[treeSet.size()];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = it.next();
        }
        if (numbers.length == 1) {
            if (numbers[0] == 1) {
                arrayList.add(numbers[0] + 1);
            } else {
                arrayList.add(numbers[0] - 1);
                arrayList.add(numbers[0] + 1);
            }
            return arrayList;
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i-1] + 1 != numbers[i] && (numbers[i-1] + 2 == numbers[i])) {
                arrayList.add(numbers[i] - 1);
            } else if (numbers[i-1] + 1 != numbers[i] && (numbers[i-1] + 2 != numbers[i])) {
                arrayList.clear();
                arrayList.add("mistake");
                return arrayList;
            }
        }

        if (arrayList.isEmpty()) {
            if (numbers[0] == 1) {
                arrayList.add(numbers[numbers.length - 1] + 1);
            } else {
                arrayList.add(numbers[0] - 1);
                arrayList.add(numbers[numbers.length - 1] + 1);
            }
            return arrayList;
        }

        if (arrayList.size() != 1) {
            arrayList.clear();
            arrayList.add("mistake");
            return arrayList;
        }
        return arrayList;
    }
}
