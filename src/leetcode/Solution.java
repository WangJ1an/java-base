package leetcode;

public class Solution {

    public boolean Find(int target, int [][] array) {
        int arrayl = array.length;
       
        for(int i = arrayl - 1,j = 0; i >= 0;) {
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

    public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        string = string.replace(" ","%20");
        return string;
    }

    public static void main(String[] args) {
        int[][] arrays = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 5;
        System.out.println(new Solution().Find(target,arrays));
    }
}