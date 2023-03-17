package offer;

/**
 * <a href=https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof>剑指 Offer 24. 反转链表</a>
 *
 * @author firefly
 * @date 2023/3/11
 */
public class Offer_24_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode p = head.next;
            head.next = newHead;
            newHead = head;
            head = p;
        }

        return newHead;
    }
}
