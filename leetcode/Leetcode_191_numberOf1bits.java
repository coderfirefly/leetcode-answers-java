/**
 *
 * <a href="https://leetcode.com/problems/number-of-1-bits/">位1的个数</a>
 */
public class Leetcode_191_numberOf1bits {
    /**
     * 方法1：逐位检查
     */
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                res++;
            }
            mask <<= 1;
        }
        return res;
    }

    /**
     * 方法2：清零最低位的1
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }


    public int hammingWeight3(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_191_numberOf1bits().hammingWeight(156));
        System.out.println(new Leetcode_191_numberOf1bits().hammingWeight2(156));
        System.out.println(new Leetcode_191_numberOf1bits().hammingWeight3(156));
    }
}
