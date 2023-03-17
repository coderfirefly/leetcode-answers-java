import java.util.Arrays;

/**
 * <a href=https://leetcode.com/problems/majority-element>众数</a>
 */
public class Leetcode_169_majorityElement {
    /**
     * 数组排序后众数始终在数组中间的位置
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
