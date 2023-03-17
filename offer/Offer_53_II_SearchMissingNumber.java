package offer;

/**
 * <a href=https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/>剑指 Offer 53 - II. 0～n-1中缺失的数字</a>
 *
 * @author firefly
 * @date 2023/3/12
 */
public class Offer_53_II_SearchMissingNumber {

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans == -1 ? nums.length : ans;
    }

}
