/**
 * <a href=https://leetcode.cn/problems/maximum-subarray-sum-after-one-operation>1746. 经过一次操作后的最大子数组和</a>
 *
 * @Author phoebe
 * @Date 2023/9/17
 */
public class Leetcode_1746 {

    public int maxSumAfterOperation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];
        int res = dp[0][1];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], 0) + nums[i];
            dp[i][1] = Math.max(Math.max(dp[i - 1][0], 0) + nums[i] * nums[i], dp[i - 1][1] + nums[i]);
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }


    public int maxSumAfterOperation2(int[] nums) {
        int dp1 = nums[0];
        int dp2 = nums[0] * nums[0];
        int res = dp2;
        for (int i = 1; i < nums.length; i++) {
            int prevDp1 = dp1;
            dp1 = Math.max(dp1, 0) + nums[i];
            dp2 = Math.max(Math.max(prevDp1, 0) + nums[i] * nums[i], dp2 + nums[i]);
            res = Math.max(res, dp2);
        }
        return res;
    }
}
