import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href=https://leetcode.cn/problems/min-stack>155. 最小栈</a>
 *
 * @Author phoebe
 * @Date 2023/6/27
 */
public class Leetcode_155_minStack {
    static class MinStack {
        private Deque<Integer> dataStack = new ArrayDeque<>();
        private Deque<Integer> minStack = new ArrayDeque<>();


        public MinStack() {
        }

        public void push(int val) {
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
            dataStack.push(val);
        }

        public void pop() {
            if (minStack.peek().equals(dataStack.peek())) {
                minStack.pop();
            }
            dataStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(1);
        obj.pop();
        Assert.assertEquals(obj.top(), 2);
        Assert.assertEquals(obj.getMin(), 1);
        obj.pop();
        Assert.assertEquals(obj.getMin(), 1);
    }
}


