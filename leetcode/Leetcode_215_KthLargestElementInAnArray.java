import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">数组第K大的元素</a>
 * @Author phoebe
 * @date 2021/3/24
 */
public class Leetcode_215_KthLargestElementInAnArray {

    public static int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int val : a) {
            heap.offer(val);
            if (heap.size() > K) {
                heap.poll();
            }
            System.out.println(heap);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 4};
        System.out.println(findKth(a, 5, 3));
    }
}
