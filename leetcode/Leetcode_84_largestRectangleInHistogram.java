import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href=https://leetcode.cn/problems/largest-rectangle-in-histogram>84. 柱状图中最大的矩形</a>
 * @Author phoebe
 * @Date 2023/6/28
 */
public class Leetcode_84_largestRectangleInHistogram {
    /**
     * 方法1：暴力枚举左右边界
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int curH = heights[i];
            while (left > 0 && heights[left-1] >= curH) {
                left--;
            }
            int right = i;
            while (right < heights.length - 1 && heights[right+1] >= curH) {
                right++;
            }
            res = Math.max(res, curH * (right - left + 1));
            while (i < heights.length - 1 && heights[i] == heights[i + 1]) {
                i++;
            }
        }
        return res;
    }

    /**
     * 方法2：单调栈，用数组记录最左和最右
     */
    public int largestRectangleArea2(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] heights = {2,1,5,6,2,3};
        Assert.assertEquals(largestRectangleArea(heights), 10);
        Assert.assertEquals(largestRectangleArea2(heights), 10);
    }
}
