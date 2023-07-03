import java.util.Arrays;

/**
 * <a href=https://leetcode.com/problems/majority-element>众数</a>
 */
public class Leetcode_169_majorityElement {
    /**
     * 方法1：数组排序后众数始终在数组中间的位置
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 方法2：分治法
     */
    public int majorityElement2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;
        int leftMajority = helper(nums, left, mid);
        int rightMajority = helper(nums, mid + 1, right);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftCount = countArray(nums, leftMajority, left, mid);
        int rightCount = countArray(nums, rightMajority, mid + 1, right);
        return leftCount > rightCount ? leftMajority : rightMajority;
    }

    private int countArray(int[] nums, int element, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == element) {
                count++;
            }
        }
        return count;
    }
    /**
     * 方法3：投票算法
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        int majority = 0;
        for(int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else if (majority != nums[i]) {
                count--;
            } else {
                count++;
            }
        }
        return majority;
    }
}
