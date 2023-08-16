package offer;

/**
 * <a href=https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof>剑指 Offer 27. 二叉树的镜像</a>
 * @Author phoebe
 * @date 2023/3/12
 */
public class Offer_27_MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newLeft = mirrorTree(root.right);
        TreeNode newRight = mirrorTree(root.left);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }
}
