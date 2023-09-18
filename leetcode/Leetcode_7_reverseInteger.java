/**
 * <a href=https://leetcode.cn/problems/reverse-integer>7. 整数反转</a>
 *
 * @Author phoebe
 * @Date 2023/9/18
 */
public class Leetcode_7_reverseInteger {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            res = res * 10 + digit;
        }
        return res;
    }
}
