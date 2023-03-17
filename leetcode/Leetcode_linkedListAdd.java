/**
 * <a href=https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b>两个链表生成相加链表</a>
 * @author firefly
 * @date 2021/3/30
 */
public class Leetcode_linkedListAdd {

    public ListNode addInList(ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);

        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(newHead.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }
}
