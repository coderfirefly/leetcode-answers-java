package offer;

/**
 * <a href=https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof>剑指 Offer 03. 数组中重复的数字</a>
 *
 * @author firefly
 * @date 2023/3/12
 */
public class Offer_03_FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            arr[num]++;
            if (arr[num] > 1) {
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
