/**
 * <a href=https://leetcode.cn/problems/palindrome-linked-list>234. 回文链表</a>
 *
 * @Author phoebe
 * @Date 2023/8/13
 */
public class Leetcode_234_palindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 后半部分链表反转
        ListNode firstTail = getFirstTail(head);
        ListNode secondHead = reverseLinkedList(firstTail.next);
        ListNode p1 = head;
        ListNode p2 = secondHead;
        boolean res = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstTail.next = reverseLinkedList(secondHead);
        return res;
    }

    private ListNode getFirstTail(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
