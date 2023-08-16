package offer;

/**
 * <a href=https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof>剑指 Offer 53 - I. 在排序数组中查找数字 I</a>
 *
 * @Author phoebe
 * @date 2023/3/12
 */
public class Offer_53_I_SearchNumber {

    public int search(int[] nums, int target) {
        int leftIndex = search(nums, target, true);
        int rightIndex = search(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length) {
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }

    public int search(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, res = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }


}
