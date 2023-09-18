import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href=https://leetcode.cn/problems/binary-tree-right-side-view>199. 二叉树的右视图</a>
 *
 * @Author phoebe
 * @Date 2023/9/4
 */
public class Leetcode_199_binaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Deque<TreeNode> tmpDeque = new LinkedList<>();
            TreeNode last = queue.peekLast();
            ans.add(last.val);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    tmpDeque.offer(node.left);
                }
                if (node.right != null) {
                    tmpDeque.offer(node.right);
                }
            }
            queue.addAll(tmpDeque);
        }
        return ans;
    }
}
