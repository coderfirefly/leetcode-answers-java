/**
 * <a href=https://leetcode.cn/problems/median-of-two-sorted-arrays>4. 寻找两个正序数组的中位数</a>
 *
 * @Author phoebe
 * @date 2023/2/11
 */
public class Leetcode_4_medianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 1) {
            return getKthElement(nums1, nums2, totalLen / 2 + 1);
        } else {
            return (getKthElement(nums1, nums2, totalLen / 2) + getKthElement(nums1, nums2, totalLen / 2 + 1)) / 2.0;
        }
    }

    // 两个有序数组的第k的元素
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0;
        while (true) {
            if (i == m) {
                return nums2[j + k - 1];
            }
            if (j == n) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            k--;
        }
    }
}
