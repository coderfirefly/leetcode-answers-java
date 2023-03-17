/**
 * 合并有序链表
 * @author firefly
 * @date 2021/5/7
 */
public class Leetcode_mergeSortedLinkedList {

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newTail.next = l1;
                newTail = l1;
                l1 = l1.next;
            } else {
                newTail.next = l2;
                newTail = l2;
                l2 = l2.next;
            }
        }
        newTail.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
