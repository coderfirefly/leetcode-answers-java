import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href=https://leetcode.cn/problems/sliding-window-maximum>239. 滑动窗口最大值</a>
 *
 * @Author phoebe
 * @Date 2023/6/28
 */
public class Leetcode_239_maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        res[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            while (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
}
