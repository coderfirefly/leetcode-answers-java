/**
 * <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">两两交换链表中的节点</a>
 */
public class Leetcode_24_swapNodesInPairs {
    /**
     * 方法1：递归
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        head.next = swapPairs(head.next.next);
        p.next = head;

        return p;
    }

    /**
     * 方法2：迭代
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode p = cur.next, q = cur.next.next;
            p.next = q.next;
            cur.next = q;
            q.next = p;
            cur = p;
        }
        return dummyHead.next;
    }


}
