import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">数组第K大的元素</a>
 *
 * @Author phoebe
 * @date 2021/3/24
 */
public class Leetcode_215_KthLargestElementInAnArray {

    /**
     * 方法1：优先级队列默认从小到大排序
     * 面试时一般不让用，需要保证O(1)的空间复杂度
     */
    public int findKthLargest(int[] a, int n, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int val : a) {
            heap.offer(val);
            if (heap.size() > K) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    /**
     * 方法2：堆排序
     */
    public int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(nums, length, i);
        }
        for (int i = length - 1; i >= length - k; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
        return nums[length - k];
    }


    private void heapify(int[] nums, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2, maxI = i;
        if (left < length && nums[left] > nums[maxI]) {
            maxI = left;
        }
        if (right < length && nums[right] > nums[maxI]) {
            maxI = right;
        }
        if (maxI != i) {
            swap(nums, i, maxI);
            heapify(nums, length, maxI);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
