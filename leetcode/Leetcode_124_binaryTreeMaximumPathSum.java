/**
 * <a href=https://leetcode.cn/problems/binary-tree-maximum-path-sum>124. 二叉树中的最大路径和</a>
 *
 * @Author phoebe
 * @Date 2023/9/4
 */
public class Leetcode_124_binaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    // 返回以该节点为起点的路径最大值
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(helper(root.left), 0);
        int rightSum = Math.max(helper(root.right), 0);
        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }
}