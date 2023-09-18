/**
 * <a href=https://leetcode.cn/problems/remove-element>27. 移除元素</a>
 *
 * @Author phoebe
 * @Date 2023/9/18
 */
public class Leetcode_27_removeElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
