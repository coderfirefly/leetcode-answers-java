import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal/"> N叉树的后序遍历</a>
 */
public class Leetcode_590_naryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }

}
