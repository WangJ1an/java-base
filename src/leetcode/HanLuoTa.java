
package leetcode;

/**
 * Created by 1 on 2017/6/10.
 */
public class HanLuoTa {
    //A-Z  65 — 90

    public static void function(int row) {
        int count = row;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print(" ");
            }
            count--;
            int x = 65;
            int n = 2 * (i+1) - 1;
            for (int j = 0; j < n; j++) {
                char ch = (char)x;
                System.out.print(ch);
                x++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        function(4);
    }

}
