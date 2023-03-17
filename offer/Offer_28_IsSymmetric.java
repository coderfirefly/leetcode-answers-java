package offer;

/**
 * <a href=https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof>剑指 Offer 28. 对称的二叉树</a>
 *
 * @author firefly
 * @date 2023/3/12
 */
public class Offer_28_IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
}
