/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">买卖股票的最佳时机</a>
 */
public class Leetcode_121_bestTimeToBuyAndSellStock {
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
