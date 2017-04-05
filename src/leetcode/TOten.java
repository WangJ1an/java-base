package leetcode;

import java.util.Scanner;

/**
 * Created by 1 on 2017/4/2.
 */
public class TOten {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            new trans(str).cal();
        }
    }

}
class trans {

    String target = null;
    long result = 0;

    public static long chengfang(int i) {
        long result = 1;
        if (i == 0)
            return result;
        result = 1;
        for (int j = 0; j < i; j++) {
            result *= 26;
        }
        return result;
    }


    public trans(String target) {
        this.target = target;
    }

    public void cal() {
        char c[] = target.toCharArray();
        int j = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            int curr = c[i] - 'a';
            result += curr * chengfang(j);
            j++;
        }
        System.out.println(result);
    }
}
