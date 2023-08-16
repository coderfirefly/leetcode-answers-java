package offer;

/**
 * <a href=https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof>剑指 Offer 11. 旋转数组的最小数字</a>
 * @Author phoebe
 * @date 2023/3/12
 */
public class Offer_11_MinArray {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]){
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
