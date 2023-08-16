package offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href=https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof>剑指 Offer 09. 用两个栈实现队列</a>
 *
 * @Author phoebe
 * @date 2023/3/11
 */
public class Offer_09_Stack2Queue {

    class CQueue {
        Deque<Integer> s1, s2;

        public CQueue() {
            s1 = new ArrayDeque<>();
            s2 = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            s1.addFirst(value);
        }

        public int deleteHead() {
            if (!s2.isEmpty()) {
                return s2.removeFirst();
            }
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.addFirst(s1.removeFirst());
            }
            return s2.removeFirst();
        }
    }

    @Test
    public void test() {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        Assert.assertEquals(1, obj.deleteHead());
    }
}
