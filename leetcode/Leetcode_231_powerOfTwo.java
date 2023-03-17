/**
 * <a href="https://leetcode.com/problems/power-of-two/">2的幂</a>
 */
public class Leetcode_231_powerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
