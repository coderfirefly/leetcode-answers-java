/**
 * <a href=https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46>两个链表的第一个公共节点</a>
 * @Author phoebe
 * @date 2021/3/30
 */
public class Leetcode_findFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode ta = pHead1, tb = pHead2;
        while (ta != tb) {
            ta = ta == null ? pHead2 : ta.next;
            tb = tb == null ? pHead1 : tb.next;
        }
        return ta;
    }
}
