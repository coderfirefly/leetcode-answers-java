package offer;

/**
 * <a href=https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/description>剑指 Offer 18. 删除链表的节点</a>
 *
 * @Author phoebe
 * @Date 2023/9/17
 */
public class Offer_18_deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode prev = head;
        while (prev.next != null && prev.next.val != val) {
            prev = prev.next;
        }
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
        return head;
    }
}
