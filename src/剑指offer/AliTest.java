package 剑指offer;

import java.util.*;

/**
 * Created by 1 on 2017/8/17.
 */
public class AliTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stunum = scanner.nextInt();
        int subjectnum = scanner.nextInt();
        int M = scanner.nextInt();
        double[] average = new double[subjectnum];
        HashMap<Integer,HashMap<Integer,String>> hashMap = new HashMap<>();
        String line = scanner.nextLine();
        while (stunum*subjectnum-- > 0) {
            line = scanner.nextLine();
            String[] strs = line.split(",");
            int sid = Integer.parseInt(strs[0]);
            int subid = Integer.parseInt(strs[1]);
            int diff = Integer.parseInt(strs[3]) - Integer.parseInt(strs[2]);
            average[subid - 1] += Integer.parseInt(strs[3]);
            HashMap<Integer,String> hashMap1 = new HashMap<>();
            hashMap1.put(subid,diff+","+Integer.parseInt(strs[3]));
            hashMap.put(sid,hashMap1);
        }

        for (int i = 0; i < average.length; i++) {
            average[i] = average[i] / stunum;
        }
        Set<Integer> set = new TreeSet<>();

        for (Map.Entry<Integer, HashMap<Integer, String>> entry : hashMap.entrySet()) {
            int sid = entry.getKey();
            HashMap<Integer, String> hashMap1 = entry.getValue();
            for (Map.Entry<Integer, String> entry1 : hashMap1.entrySet()){
                int subid = entry1.getKey();
                String string = entry1.getValue();
                String[] strings = string.split(",");
                int diff = Integer.parseInt(strings[0]);
                int socre = Integer.parseInt(strings[1]);

                if (diff >= 0 && socre > average[subid - 1]) {
                    set.add(sid);
                }

                if (socre < average[subid - 1]) {
                    set.remove(sid);
                }

            }
        }
        Integer[] integers = set.toArray(new Integer[set.size()]);
        for (int i = 0; i < integers.length; i++) {
            if (i == set.size() - 1){
                System.out.println(integers[i]);
            } else {
                System.out.println(integers[i] + ",");
            }
        }
    }
}
