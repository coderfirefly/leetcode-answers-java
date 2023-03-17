package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href=https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/>剑指 Offer 32 - III. 从上到下打印二叉树 III</a>
 * @author firefly
 * @date 2023/3/12
 */
public class Offer_32_III_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> curLayer = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                if (reverse) {
                    curLayer.add(0, cur.val);
                } else {
                    curLayer.add(cur.val);
                }


                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
            reverse = !reverse;
            res.add(curLayer);
        }
        return res;
    }
}
