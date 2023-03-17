package offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href=https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof>剑指 Offer 30. 包含min函数的栈</a>
 *
 * @author firefly
 * @date 2023/3/11
 */
public class Offer_30_MinStack {
    class MinStack {

        private Deque<Integer> stack1, stack2;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int x) {
            stack1.addFirst(x);
            if (stack2.isEmpty() || x < stack2.peekFirst()) {
                stack2.addFirst(x);
            } else {
                stack2.addFirst(stack2.peekFirst());
            }

        }

        public void pop() {
            stack1.removeFirst();
            stack2.removeFirst();
        }

        public int top() {
            return stack1.peekFirst();
        }

        public int min() {
            return stack2.peekFirst();
        }
    }

    @Test
    public void test() {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        Assert.assertEquals(-1, obj.top());
        obj.pop();
        Assert.assertEquals(-2, obj.min());
    }

    /**
     * 方法2：不用辅助栈
     */
    class MinStack2 {

        Deque<Long> stack;
        Long min;

        /**
         * initialize your data structure here.
         */
        public MinStack2() {
            stack = new ArrayDeque<>();
            min = Long.MAX_VALUE;
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.addFirst(0L);
                min = (long) x;
            } else {
                stack.addFirst((long) x - min);
                min = Math.min(min, x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            if (stack.peekFirst() < 0) {
                min = min - stack.peekFirst();
            }
            stack.removeFirst();
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            if (stack.peekFirst() < 0) {
                return Math.toIntExact(min);
            } else {
                return Math.toIntExact(min + stack.peekFirst());
            }
        }

        public int min() {
            return Math.toIntExact(min);
        }


    }

    @Test
    public void test2() {
        MinStack2 obj = new MinStack2();
        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        Assert.assertEquals(-1, obj.top());
        obj.pop();
        Assert.assertEquals(-2, obj.min());
    }
}
