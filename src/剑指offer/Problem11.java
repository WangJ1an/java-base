package 剑指offer;

import org.junit.Test;

import java.util.*;

/**
 * Created by 1 on 2017/8/10.
 */
public class Problem11 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (j == i || !charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    @Test
    public void fun() {
        ArrayList<String> list = Permutation("abc");
        for (String str : list) {
            System.out.println(str);
        }
    }

}
