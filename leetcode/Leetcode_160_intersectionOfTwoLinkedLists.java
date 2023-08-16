import java.util.HashSet;
import java.util.Set;

/**
 * <a href=https://leetcode.cn/problems/intersection-of-two-linked-lists>160. 相交链表</a>
 *
 * @Author phoebe
 * @Date 2023/8/16
 */
public class Leetcode_160_intersectionOfTwoLinkedLists {
    /**
     * 方法1：借助集合判断第一个存在的即为相交点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode p1 = headA;
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;

        }
        ListNode p2 = headB;
        while (p2 != null) {
            if (set.contains(p2)) {
                return p2;
            } else {
                p2 = p2.next;
            }
        }
        return null;
    }

    /**
     * 方法2：
     * 链表1长度 ：m = a + c
     * 链表2长度： n = b + c
     * 各自走完 a + b + c 即为相交点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
