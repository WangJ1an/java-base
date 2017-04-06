package leetcode;

import java.util.*;

/**
 * Created by 1 on 2017/4/2.
 */
public class CycleWord {
    /*
    * 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。
    * 例如：picture 和 turepic 就是属于同一种循环单词。
     * 现在给出n个单词，需要统计这个n个单词中有多少种单词
    * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int num = in.nextInt();
        String[] strs = new String[num];
        for (int i = 0; i < num; i++) {
            strs[i] = in.next();
        }
        System.out.println(function(strs));
    }

    private static int function(String[] strings) {
        int temp = 0;
        int sum = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (isExist(strings[i],it.next())) {
                    temp = 1;
                }
            }
            if (temp != 1) {
                sum++;
                arrayList.add(strings[i]);
            } else {
                temp = 0;
            }
        }
        return sum;
    }

    private static boolean isExist(String left, String right) {
        int lenl = left.length();
        int lenr = right.length();

        if (lenl != lenr || lenl == 0 || lenr == 0) {
            return false;
        }

        left = left.concat(left);

        if (left.contains(right)) {
            return true;
        } else {
            return false;
        }
    }
}
