package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 1 on 2017/7/31.
 */
public class SumChar {
    /**
     * 输入任意字符串，统计其中字符出现的个数
     *
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            HashMap<Character,Integer> hashMap = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if (hashMap.containsKey(ch)) {
                    hashMap.put(ch,hashMap.get(ch)+1);
                } else {
                    hashMap.put(ch,1);
                }
            }
            for (HashMap.Entry<Character,Integer> entry: hashMap.entrySet()) {
                char ch = entry.getKey();
                int num = entry.getValue();
                System.out.println(ch+"---------"+num);
            }
        }

        SumChar sumChar = new SumChar();

    }


    public boolean Find(int target, int [][] array) {
        int arrayl = array.length;

        for(int i = arrayl - 1,j = 0; i >= 0 && j < array[i].length;) {
            int len = array[i].length;
            if(array[i][j] > target) {
                i--;
                continue;
            } else if(array[i][j] < target) {
                j++;
                continue;
            }
            if(array[i][j] == target) {
                return true;
            }
        }
        return false;
    }

}
