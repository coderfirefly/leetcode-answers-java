import java.util.Stack;

/**
 * <a href=https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6>用两个栈实现一个队列</a>
 * @author firefly
 * @date 2021/3/25
 */
public class Leetcode_TwoStack2Queue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int data) {
        stack1.push(data);
    }

    public int pop() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("empty queue");
        }
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
