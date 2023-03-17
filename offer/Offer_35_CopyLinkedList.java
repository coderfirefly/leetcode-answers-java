package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href=https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof>剑指 Offer 35. 复杂链表的复制</a>
 *
 * @author firefly
 * @date 2023/3/11
 */
public class Offer_35_CopyLinkedList {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
