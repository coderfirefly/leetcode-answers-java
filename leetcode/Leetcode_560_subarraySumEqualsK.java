import java.util.HashMap;
import java.util.Map;

/**
 * <a href=https://leetcode.cn/problems/subarray-sum-equals-k>560. 和为 K 的子数组</a>
 *
 * @Author phoebe
 * @Date 2023/8/12
 */
public class Leetcode_560_subarraySumEqualsK {
    /**
     * 方法1：暴力枚举
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; --j) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }
    /**
     * 方法2：前缀和+哈希
     */
    public int subarraySum2(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
