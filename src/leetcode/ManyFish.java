package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by 1 on 2017/4/2.
 */
public class ManyFish {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String round = in.nextLine();
        String[] rounds = round.split(" ");
        int newMinSize = Integer.parseInt(rounds[0]);
        int newMaxSize = Integer.parseInt(rounds[1]);
        int fishes = Integer.parseInt(in.nextLine());
        String fishSize = in.nextLine();
        String[] fishSizeArray = fishSize.split(" ");
        HashSet<Integer> hsFish = new HashSet<>(fishSizeArray.length);
        for (int i = 0; i < fishSizeArray.length; i++) {
            hsFish.add(Integer.valueOf(fishSizeArray[i]));
        }

        int count = 0;
        for (int i = newMinSize; i <= newMaxSize; i++) {
            int n = 0;
            Iterator<Integer> it = hsFish.iterator();
            while (it.hasNext()) {
                int temp = it.next();
                if ((temp < 2*i || temp > 10*i) && (i < 2*temp || i > 10*temp)) {
                    n++;
                }
            }
            if (n == hsFish.size()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
