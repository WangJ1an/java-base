package leetcode;

import java.util.*;

/**
 * Created by 1 on 2017/4/16.
 */
public class StringSub {

    //把一个字符串分割成单词，并按升序排列

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.nextLine();

        /*String[] strings = string.split("[ |,|0-9|.]+");

        stringSort(strings);

        for (String str :
                strings) {
            System.out.println(str);
        }*/

        ArrayList<String> arrayList = splitString(string);
        Collections.sort(arrayList);
        for (String str :
                arrayList) {
            System.out.println(str);
        }
    }

    public static ArrayList<String> splitString(String string) {
        StringBuffer sb = new StringBuffer();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            //A-Z  65 — 90
            //a-z  97 — 122
            if (c >= 65 && c <= 90 || c >= 97 && c <= 122) {
                sb.append(c);
                if (i == string.length() - 1) {
                    arrayList.add(sb.toString());
                    sb = new StringBuffer();
                }
            } else {
                if (!sb.toString().isEmpty()) {
                    arrayList.add(sb.toString());
                    sb = new StringBuffer();
                }
            }

        }
        return arrayList;
    }

    public static void stringSort(String[] strings) {
        quickSort(strings,0,strings.length - 1);
    }

    private static void quickSort(String[] strings, int low, int high) {
        if (low < high) {
            int mid = getMiddle(strings,low,high);
            quickSort(strings,low,mid-1);
            quickSort(strings,mid+1,high);
        }
    }

    private static int getMiddle(String[] strings, int low, int high) {
        String point = strings[low];
        while (low < high) {
            while (low < high && strings[high].compareTo(point) >= 0) {
                high--;
            }
            strings[low] = strings[high];

            while (low < high && strings[low].compareTo(point) <= 0) {
                low++;
            }
            strings[high] = strings[low];
        }
        strings[low] = point;
        return low;
    }
}
