import java.util.Arrays;

/**
 * <a href=https://leetcode.cn/problems/3sum-closest>16. 最接近的三数之和</a>
 *
 * @Author phoebe
 * @Date 2023/9/18
 */
public class Leetcode_16_3sumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    while (i < j && nums[j] == nums[++i]) ;
                }
            }
        }
        return res;
    }
}
