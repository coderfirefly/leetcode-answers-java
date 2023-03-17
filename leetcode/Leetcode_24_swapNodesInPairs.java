/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">两两交换链表中的节点</a>
 */
public class Leetcode_24_swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        head.next = swapPairs(head.next.next);
        p.next = head;

        return p;
    }
}
