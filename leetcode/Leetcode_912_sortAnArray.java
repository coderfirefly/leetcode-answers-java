/**
 * <a href=https://leetcode.cn/problems/sort-an-array>912. 排序数组</a>
 *
 * @Author phoebe
 * @Date 2023/9/5
 */
public class Leetcode_912_sortAnArray {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, len, i);
        }
        return nums;
    }

    private void heapify(int[] nums, int len, int i) {
        int left = 2 * i + 1, right = 2 * i + 2, maxI = i;
        if (left < len && nums[left] > nums[maxI]) {
            maxI = left;
        }
        if (right < len && nums[right] > nums[maxI]) {
            maxI = right;
        }
        if (maxI != i) {
            swap(nums, i, maxI);
            heapify(nums, len, maxI);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
