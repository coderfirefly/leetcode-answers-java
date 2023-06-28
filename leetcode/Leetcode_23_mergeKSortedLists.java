/**
 * <a href=https://leetcode.cn/problems/merge-k-sorted-lists>23. 合并 K 个升序链表</a>
 *
 * @Author phoebe
 * @Date 2023/6/21
 */
public class Leetcode_23_mergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeHelper(lists, 0, lists.length - 1);
    }

    public ListNode mergeHelper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(mergeHelper(lists, left, mid), mergeHelper(lists, mid + 1, right));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return newHead.next;
    }

}
