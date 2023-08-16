package offer;

/**
 * <a href=https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof>剑指 Offer 63. 股票的最大利润</a>
 *
 * @Author phoebe
 * @date 2023/4/1
 */
public class Offer_63_MaxProfit {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
