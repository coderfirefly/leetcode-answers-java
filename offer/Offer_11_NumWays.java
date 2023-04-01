package offer;

/**
 * <a href=https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof>剑指 Offer 10- II. 青蛙跳台阶问题</a>
 * @author firefly
 * @date 2023/4/1
 */
public class Offer_11_NumWays {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int f0 = 1, f1 = 1, tmp;
        for (int i = 2; i <=n; i++) {
            tmp = f1;
            f1 = (f0 + f1) % 1000000007;
            f0 = tmp;
        }
        return f1;
    }
}
