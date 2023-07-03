import java.util.ArrayList;
import java.util.List;

/**
 * <a href=https://leetcode.cn/problems/binary-tree-postorder-traversal>145. 二叉树的后序遍历</a>
 *
 * @Author phoebe
 * @Date 2023/6/28
 */
public class Leetcode_145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            helper(node.left, res);
        }
        if (node.right != null) {
            helper(node.right, res);
        }
        res.add(node.val);
    }
}
