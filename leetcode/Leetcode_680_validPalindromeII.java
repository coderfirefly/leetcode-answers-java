import org.junit.Assert;
import org.junit.Test;

/**
 * <a href=https://leetcode.cn/problems/valid-palindrome-ii/>680. 验证回文串 II</a>
 *
 * @Author phoebe
 * @date 2022/12/30
 */
public class Leetcode_680_validPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        if (left < right) {
            return validPalindrome(s, left + 1, right) || validPalindrome(s, left, right - 1);
        }
        return true;
    }

    public boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(validPalindrome("aba"));
        Assert.assertFalse(validPalindrome("abc"));
    }
}
