package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by 1 on 2017/8/11.
 */
public class Problem14 {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        ArrayList<String> arrayList = new ArrayList<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(String.valueOf(numbers[i]));
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str :
                arrayList) {
            sb.append(str);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        int[] nums = new int[]{3,32,321};
        System.out.println(PrintMinNumber(nums));
    }
}
