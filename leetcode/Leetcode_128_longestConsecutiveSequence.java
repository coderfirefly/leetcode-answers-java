import java.util.HashSet;
import java.util.Set;

/**
 * <a href=https://leetcode.cn/problems/longest-consecutive-sequence>128. 最长连续序列</a>
 *
 * @Author phoebe
 * @Date 2023/8/12
 */
public class Leetcode_128_longestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curLen = 1, prev = num;
                while (set.contains(prev + 1)) {
                    prev = prev + 1;
                    curLen++;
                }
                res = Math.max(curLen, res);
            }
        }
        return res;
    }
}
