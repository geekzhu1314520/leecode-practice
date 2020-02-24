package dynamic;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/submissions/
 */
public class BestTimeBuySellStockIV {

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

        int[][][] result = new int[length][k + 1][2];
        for (int kk = 0; kk <= k; kk++) {
            result[0][kk][0] = 0;
            result[0][kk][1] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
            result[i][0][0] = 0;
            result[i][0][1] = Math.max(result[i - 1][0][1], result[i - 1][0][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                result[i][j][0] = Math.max(result[i - 1][j][0], result[i - 1][j - 1][1] + prices[i]);
                result[i][j][1] = Math.max(result[i - 1][j][1], result[i - 1][j][0] - prices[i]);
            }
        }

        for (int i = 0; i <= k; i++) {
            if (max < result[length - 1][i][0]) {
                max = result[length - 1][i][0];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] prices = new int[1000];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = (int) (100 * Math.random() + 1);
        }
        int k = 100;
        BestTimeBuySellStockIV stock = new BestTimeBuySellStockIV();
        System.out.println(stock.maxProfit(k, prices));
    }

}
