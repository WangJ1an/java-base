package 剑指offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by 1 on 2017/8/11.
 */
public class Problem16 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (list.contains(str.charAt(i))) {
                hashMap.remove(str.charAt(i));
            } else {
                list.add(str.charAt(i));
                hashMap.put(str.charAt(i),i);
            }
        }
        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()) {
            return entry.getValue();
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(FirstNotRepeatingChar("abaccdeff"));
    }
}
