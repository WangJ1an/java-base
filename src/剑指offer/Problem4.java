package 剑指offer;

/**
 * Created by 1 on 2017/8/9.
 */
public class Problem4 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。
     * （ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag = false;

        if (root1 != null && root2 != null) {

            if (root1.val == root2.val) {
                flag = isSubtree(root1, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.left, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);

    }
}
