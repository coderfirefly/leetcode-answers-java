import org.junit.Assert;
import org.junit.Test;

/**
 * <a href=https://leetcode.cn/problems/reverse-string>344. 反转字符串</a>
 * @Author phoebe
 * @date 2021/3/30
 */
public class Leetcode_344_ReverseString {

    public void reverseString(char[] s) {
        if (s == null) {
            return;
        }
        for (int i = 0, j = s.length -1; i < j; i++,j--) {
            char tmp =s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }

    @Test
    public void test1() {
        Leetcode_344_ReverseString solution = new Leetcode_344_ReverseString();
        char[] s = "hello".toCharArray();
        solution.reverseString(s);
        Assert.assertEquals("olleh", String.valueOf(s));
    }
}
