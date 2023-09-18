/**
 * <a href=https://leetcode.cn/problems/balanced-binary-tree>110. 平衡二叉树</a>
 *
 * @Author phoebe
 * @Date 2023/9/4
 */
public class Leetcode_110_balancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(helper(root.left) - helper(root.right)) <= 1;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}
