/**
 * <a href=https://leetcode.cn/problems/median-of-two-sorted-arrays>4. 寻找两个正序数组的中位数</a>
 *
 * @author firefly
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
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        // 数组的起始查找位置
        int index1 = 0, index2 = 0, kthElement = 0;
        while (true) {
            // nums1为空
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            // nums2 为空
            if (index2 == len2) {
                return nums1[index1 + k - 1];
            }
            // 循环结束
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k -= newIndex1 - index1 + 1;
                index1 = newIndex1 + 1;
            } else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }
        }
    }
}
