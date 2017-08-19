package 剑指offer;

import org.junit.Test;

/**
 * Created by 1 on 2017/8/11.
 */
public class Problem17 {
    public int InversePairs(int [] array) {
        if (array == null) {
            return 0;
        }
        mergeSort(array,0,array.length-1);
        return count;
    }

    public void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) >>> 1;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
        }
    }

    private int count = 0;
    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int index0 = start;
        int index1 = mid+1;
        int k = 0;
        while (index0 <= mid && index1 <= end) {
            if (array[index0] <= array[index1]) {
                temp[k++] = array[index0++];
            } else {
                temp[k++] = array[index1++];
                count += mid - index0 + 1;
                count %= 1000000007;
            }
        }
        while (index0 <= mid) {
            temp[k++] = array[index0++];
        }
        while (index1 <= end) {
            temp[k++] = array[index1++];
        }

        for (k = 0; k < temp.length; k++) {
            array[start+k] = temp[k];
        }
    }

    @Test
    public void test() {
//        int[] array = new int[] {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int[] array = new int[] {1,3,2,6,4,7,5};
        int num = InversePairs(array);
        System.out.println(num);
    }
}
