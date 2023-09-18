import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href=https://leetcode.cn/problems/4sum>18. 四数之和</a>
 *
 * @Author phoebe
 * @Date 2023/9/18
 */
public class Leetcode_18_4sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1, n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[m], nums[n])));
                        while (m < n && nums[m] == nums[++m]) ;
                        while (m < n && nums[n] == nums[--n]) ;
                    } else if (sum < target) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }
        return res;
    }
}
