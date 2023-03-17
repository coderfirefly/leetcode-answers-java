/**
 * <a href=https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6>移除链表的倒数第N个节点</a>
 * @author firefly
 * @date 2021/3/25
 */
public class Leetcode_removeNthFromEnd {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return slow.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
