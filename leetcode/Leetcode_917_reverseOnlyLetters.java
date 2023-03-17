import org.junit.Assert;
import org.junit.Test;

/**
 * <a href=https://leetcode.cn/problems/reverse-only-letters/>917. 仅仅反转字母</a>
 *
 * @author firefly
 * @date 2022/12/24
 */
public class Leetcode_917_reverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !isLetters(array[i])) {
                i++;
            }
            while (i < j && !isLetters(array[j])) {
                j--;
            }
            if (i == j) {
                break;
            }

            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;

        }
        return String.valueOf(array);
    }

    public boolean isLetters(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    @Test
    public void test1() {
        Assert.assertEquals("dc-ba", reverseOnlyLetters("ab-cd"));
    }
}
