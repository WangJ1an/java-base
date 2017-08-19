package 剑指offer;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/12.
 */
public class Problem19 {
    public int GetNumberOfK(int [] array , int k) {
        int low = 0;
        int high = array.length - 1;
        int index0 = getFirstK(array,k,low,high);
        int index1 = getLastK(array,k,low,high);

        if (index0 > -1 && index1 > -1) {
            return index1 - index0 + 1;
        }
        return 0;
    }

    public int getFirstK(int[] array, int k, int low, int high) {
        int mid = (low + high) >>> 1;
        while (low <= high) {
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else if (mid > 0 && array[mid - 1] == k) {
                high = mid - 1;
            } else {
                return mid;
            }
            mid = (low + high) >>> 1;
        }
        return -1;
    }

    public int getLastK(int[] array, int k, int low, int high) {
        int mid = (low + high) >>> 1;
        while (low <= high) {
            if (array[mid] > k) {
                high = mid - 1;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else if (mid < array.length - 1 && array[mid + 1] == k) {
                low = mid + 1;
            } else {
                return mid;
            }
            mid = (low + high) >>> 1;

        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(nums,5));
    }
}
