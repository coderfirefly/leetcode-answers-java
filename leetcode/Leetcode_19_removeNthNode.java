/**
 * <a href=https://leetcode.cn/problems/remove-nth-node-from-end-of-list>19. 删除链表的倒数第 N 个结点</a>
 *
 * @Author phoebe
 * @Date 2023/8/16
 */
public class Leetcode_19_removeNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = getLengthOfList(head);
        count = count - n;
        if (count == 0) {
            return head.next;
        }
        ListNode cur = head;
        for (int i = 1; i < count; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    private int getLengthOfList(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
