package 剑指offer;


/**
 * Created by 1 on 2017/8/17.
 */
public class Problem25 {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n-1,m)+m)%n;
    }
}
