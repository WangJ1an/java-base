package 剑指offer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by 1 on 2017/8/12.
 */
public class Problem20 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    /**
     *输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * 任意节点左右子树相差不超过1
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {

        getDepth(root);
        return isBalanced;
    }

    private boolean isBalanced=true;
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;

    }
    public void FindNumsAppearOnce(int [] array) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!hashMap.containsKey(array[i])) {
                hashMap.put(array[i],1);
            } else if (hashMap.containsKey(array[i])) {
                hashMap.remove(array[i]);
            }
        }
        Set<Integer> set =  hashMap.keySet();
        Integer[] arr = set.toArray(new Integer[set.size()]);

        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    @Test
    public void test() {
        int[] nums = new int[]{2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(nums);
    }
}
