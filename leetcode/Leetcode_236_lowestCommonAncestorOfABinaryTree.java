/**
 * <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">二叉树的最近公共祖先</a>
 */
public class Leetcode_236_lowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 在root的左右子树分别找到p和q，此时root就是最近公共节点；
        if (left != null && right != null) {
            return root;
        }
        // 只在一边找到p或q，那么先找到的p或q就是最近公共节点
        return left != null ? left : right;
    }

}
