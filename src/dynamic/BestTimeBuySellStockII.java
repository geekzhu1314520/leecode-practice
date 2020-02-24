package dynamic;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeBuySellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] result = new int[prices.length][2];
        result[0][0] = 0;
        result[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            result[i][0] = this.max(result[i-1][0], result[i-1][1] + prices[i]);
            result[i][1] = this.max(result[i-1][1], result[i-1][0] - prices[i]);
        }

        return result[prices.length-1][0];
    }

    private int max(int v1, int v2) {
        return v1 >= v2 ? v1 : v2;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeBuySellStockII stock = new BestTimeBuySellStockII();
        System.out.println(stock.maxProfit(prices));
    }

}
