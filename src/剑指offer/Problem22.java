package 剑指offer;

import java.util.ArrayList;

/**
 * Created by 1 on 2017/8/12.
 */
public class Problem22 {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
     * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int point1 = 0;
        int point2 = array.length - 1;
        for (; point1 < point2; ) {
            int num1 = array[point1];
            int num2 = array[point2];
            if (num1+num2 == sum) {
                if (!arrayList.isEmpty()) {
                    if (arrayList.get(0) * arrayList.get(0) > num1*num2) {
                        arrayList.clear();
                        arrayList.add(num1);
                        arrayList.add(num2);
                    }
                    break;
                }
                arrayList.add(num1);
                arrayList.add(num2);
            } else if (num1+num2 < sum) {
                point1++;
            } else if (num1+num2 > sum) {
                point2--;
            }
        }
        return arrayList;
    }
}
