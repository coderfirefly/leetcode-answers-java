import org.junit.Assert;
import org.junit.Test;

/**
 * <a href=https://leetcode.cn/problems/reverse-string-ii/>541. 反转字符串 II</a>
 *
 * @author firefly
 * @date 2021/3/30
 */
public class Leetcode_541_reverseStringII {

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverseStr(array, i, Math.min(i + k, n) - 1);
        }
        return String.valueOf(array);
    }


    public void reverseStr(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    @Test
    public void test1() {
        Leetcode_541_reverseStringII solution = new Leetcode_541_reverseStringII();
        Assert.assertEquals("abcdefg", solution.reverseStr("bacdfeg", 2));
    }
}
