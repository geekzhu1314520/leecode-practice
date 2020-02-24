package dynamic;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
 */
public class BestTimeBuySellStockIV01 {

    public int maxProfit(int k, int[] prices) {

        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int length = prices.length;
        int max = 0;
        if (k >= length / 2) {
            for (int i = 1; i < length; i++) {
                if (prices[i] > prices[i - 1]) {
                    max += prices[i] - prices[i - 1];
                }
            }
            return max;
        }

        int[][] result = new int[k + 1][2];
        for (int kk = 0; kk < k; kk++) {
            result[kk][1] = -prices[0];
        }

        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= k; j++) {
                result[j][0] = Math.max(result[j][0], result[j - 1][1] + prices[i]);
                result[j][1] = Math.max(result[j][1], result[j][0] - prices[i]);
            }
            result[0][1] = Math.max(result[0][1], -prices[i]);
        }
        return result[k][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        int k = 7;
        BestTimeBuySellStockIV01 stock = new BestTimeBuySellStockIV01();
        System.out.println(stock.maxProfit(k, prices));
    }

}
