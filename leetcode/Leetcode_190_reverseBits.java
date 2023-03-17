/**
 * <a href="https://leetcode.com/problems/reverse-bits/">颠倒二进制位</a>
 */
public class Leetcode_190_reverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res |= (n >> (31 - i) & 1) << i;
        }
        return res;
    }

    public int reverseBits2(int n) {
        return Integer.reverse(n);
    }
}
