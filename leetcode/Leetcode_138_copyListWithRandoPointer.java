import java.util.HashMap;
import java.util.Map;

/**
 * <a href=https://leetcode.cn/problems/copy-list-with-random-pointer>138. 复制带随机指针的链表</a>
 *
 * @Author phoebe
 * @Date 2023/8/16
 */
public class Leetcode_138_copyListWithRandoPointer {
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

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
