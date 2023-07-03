import java.util.ArrayList;
import java.util.List;

/**
 * <a href=https://leetcode.cn/problems/n-ary-tree-level-order-traversal>429. N 叉树的层序遍历</a>
 *
 * @Author phoebe
 * @Date 2023/6/28
 */
public class Leetcode_429_naryTreeLevelOrderTraversal {

    /**
     * 递归
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(Node root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (Node node : root.children) {
            helper(node, level + 1, res);
        }
    }
}
