import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href=https://leetcode.cn/problems/trapping-rain-water>42. 接雨水</a>
 *
 * @Author phoebe
 * @Date 2023/6/28
 */
public class Leetcode_42_trappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int wi = i - left - 1;
                int hi = Math.min(height[left], height[i]) - height[top];
                res += wi * hi;
            }
            stack.push(i);
        }
        return res;
    }
}
