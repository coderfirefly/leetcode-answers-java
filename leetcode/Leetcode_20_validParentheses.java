import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href=https://leetcode.cn/problems/valid-parentheses>20. 有效的括号</a>
 *
 * @Author phoebe
 * @Date 2023/6/27
 */
public class Leetcode_20_validParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
