package 剑指offer;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 1 on 2017/8/13.
 */
public class WangYi2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            HashMap<Character,Integer> hashMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (hashMap.containsKey(str.charAt(i))) {
                    int value = hashMap.get(str.charAt(i));
                    hashMap.put(str.charAt(i),++value);
                } else {
                    hashMap.put(str.charAt(i),1);
                }
            }
            int n = hashMap.size();
            if (n > 2) {
                System.out.println(0);
            } else {
                System.out.println(n);
            }

        }
    }
}
