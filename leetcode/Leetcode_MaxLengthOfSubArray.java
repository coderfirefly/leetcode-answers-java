import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4">最长不重复子数组</a>
 * @author firefly
 * @date 2021/3/25
 */
public class Leetcode_MaxLengthOfSubArray {

    public static int maxLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;
        for (int i = 0, j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j])) {
                i = Math.max(i, map.get(arr[j]));
            }

            maxSize = Math.max(maxSize, j - i + 1);
            map.put(arr[j], j + 1);
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 3};
        System.out.println(maxLength(arr));
    }
}
