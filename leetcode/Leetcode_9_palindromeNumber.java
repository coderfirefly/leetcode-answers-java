/**
 * <a href=https://leetcode.cn/problems/palindrome-number>9. 回文数</a>
 *
 * @Author phoebe
 * @Date 2023/9/18
 */
public class Leetcode_9_palindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return reverse(x) == x;
    }

    private int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            x = x / 10;
            res = res * 10 + tmp;
        }
        return res;
    }
}
