package leetcode;

import java.util.Scanner;

/**
 * Created by 1 on 2017/4/5.
 */
public class DNA {
//    DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。
//    碱基互补配对原则：A和T是配对的，C和G是配对的。如果两条碱基链长度是相同的并且每个位置的
//    碱基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。现在给出两条碱基链，允许在其中一
//    条上做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String[] strs = string.split(" ");
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char ch1 = strs[0].charAt(i);
            char ch2 = strs[1].charAt(i);
            if (judgment(ch1, ch2)) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }

    public static boolean judgment(char ch1, char ch2) {
        boolean flag = false;
        switch (ch1) {
            case 'A' :
                if (ch2 == 'T') {
                    flag = true;
                }
                break;
            case 'T' :
                if (ch2 == 'A') {
                    flag = true;
                }
                break;
            case 'C' :
                if (ch2 == 'G') {
                    flag = true;
                }
                break;
            case 'G' :
                if (ch2 == 'C') {
                    flag = true;
                }
                break;
            default:
                break;
        }
        return flag;
    }
}
