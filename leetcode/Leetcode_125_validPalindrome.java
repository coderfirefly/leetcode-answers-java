import org.junit.Assert;
import org.junit.Test;

/**
 * <a href=https://leetcode.cn/problems/valid-palindrome>125. 验证回文串</a>
 *
 * @Author phoebe
 * @date 2022/12/26
 */
public class Leetcode_125_validPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        StringBuilder sbReversed = new StringBuilder(sb).reverse();
        return sb.toString().equals(sbReversed.toString());
    }

    @Test
    public void test() {
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertTrue(isPalindrome2("A man, a plan, a canal: Panama"));
    }
}
