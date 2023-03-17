/**
 * <a href="https://leetcode.com/problems/counting-bits/">比特位计数</a>
 */
public class Leetcode_338_countingBits {
    /**
     * eg. res[3] = res[1] + 3 % 2
     * 11 -> 1 + 1
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + i % 2;
        }
        return res;
    }
}
