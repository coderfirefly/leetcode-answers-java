/**
 * <a href=https://leetcode.cn/problems/sort-list>148. 排序链表</a>
 *
 * @Author phoebe
 * @Date 2023/8/16
 */
public class Leetcode_148_sortList {
    public ListNode sortList(ListNode head) {
        return sortHelper(head, null);
    }

    private ListNode sortHelper(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode p1 = head, p2 = head;
        while (p1 != tail && p1.next != tail) {
            p1 = p1.next.next;
            p2 = p2.next;
        }

        ListNode middle = p2;
        ListNode list1 = sortHelper(head, middle);
        ListNode list2 = sortHelper(middle, tail);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(), cur = dummyHead;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }
}
