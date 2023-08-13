import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href=https://leetcode.cn/problems/trapping-rain-water>42. 接雨水</a>
 *
 * @Author phoebe
 * @Date 2023/6/28
 */
public class Leetcode_42_trappingRainWater {
    /**
     * 方法1：单调栈
     */
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

    /**
     * 方法2：双指针
     */
    public int trap2(int[] height) {
        int res = 0;
        int left = 0, leftMax = height[0], right = height.length - 1, rightMax = height[height.length - 1];
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
