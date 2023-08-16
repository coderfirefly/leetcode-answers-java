package offer;

/**
 * <a href=https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof>剑指 Offer 42. 连续子数组的最大和</a>
 *
 * @Author phoebe
 * @date 2023/4/1
 */
public class Offer_42_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, prevSum = 0;
        for (int num : nums) {
            prevSum = Math.max(prevSum + num, num);
            maxSum = Math.max(maxSum, prevSum);
        }
        return maxSum;
    }
}
