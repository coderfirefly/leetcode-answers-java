package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href=https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/?favorite=xb9nqhhg>剑指 Offer 32 - II. 从上到下打印二叉树 II</a>
 *
 * @Author phoebe
 * @date 2023/3/12
 */
public class Offer_32_II_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLayer = new ArrayList<>();
            int nodeCount = queue.size();
            for (int i = 0; i < nodeCount; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                curLayer.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(curLayer);

        }
        return res;
    }
}
