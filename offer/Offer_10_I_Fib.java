package offer;

/**
 * <a href=https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof>剑指 Offer 10- I. 斐波那契数列</a>
 *
 * @author firefly
 * @date 2023/3/18
 */
public class Offer_10_I_Fib {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int f0 = 0, f1 = 1, f2 = 1;
        for (int i = 2; i <= n; i++) {
            f2 = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}
