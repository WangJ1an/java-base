package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by 1 on 2017/8/17.
 */
public class Problem23 {
    /**
     * 题目描述
     小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

     输出描述:
     输出所有和为S的连续正数序列。
     序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum < 3) return list;
        int l = (int) Math.sqrt(2 * sum);
        for (int i = 2; i <= l; i++) {
            if (2*sum % i == 0) {
                int k = 2*sum/i;
                if (k % 2 == 0 && i % 2 != 0 || k % 2 != 0 && i % 2 == 0) {
                    int a1 = (k - i + 1) / 2;
                    int an = (k + i - 1) / 2;
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = a1; j <= an ; j++) {
                        arrayList.add(j);
                    }
                    list.add(arrayList);
                }
            }
        }
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        return list;
    }
    public String ReverseSentence(String str) {
        String[] strs = str.split(" ");
        if (strs.length > 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = strs.length - 1; i >= 0; i--) {
                sb.append(strs[i] + " ");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
        return str;
    }

    @Test
    public void test() {
        /*ArrayList<ArrayList<Integer>> list = FindContinuousSequence(9);
        for (ArrayList<Integer> l :
                list) {
            System.out.println(Arrays.toString(list.toArray()));
        }*/
        System.out.println(ReverseSentence(" "));
    }
}
