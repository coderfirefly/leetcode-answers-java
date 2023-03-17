package offer;

import java.util.ArrayList;

/**
 * <a href=https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof>剑指 Offer 06. 从尾到头打印链表</a>
 *
 * @author firefly
 * @date 2023/3/11
 */
public class Offer_06_PrintLinkedListReverse {

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        recursiveTraversals(head, result);
            return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void recursiveTraversals(ListNode node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        recursiveTraversals(node.next, result);
        result.add(node.val);
    }

}
