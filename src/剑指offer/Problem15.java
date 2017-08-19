package 剑指offer;

/**
 * Created by 1 on 2017/8/11.
 */
public class Problem15 {

    /**
     * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] nums = new int[index];
        nums[0] = 1;
        int k2 = 0,k3 = 0,k5 = 0;
        for (int i = 1; i < index; i++) {
            nums[i] = Math.min(nums[k2]*2, Math.min(nums[k3]*3,nums[k5]*5));
            if (nums[i] == nums[k2] * 2) k2++;
            if (nums[i] == nums[k3] * 3) k3++;
            if (nums[i] == nums[k5] * 5) k5++;
        }
        return nums[index - 1];
    }
}
