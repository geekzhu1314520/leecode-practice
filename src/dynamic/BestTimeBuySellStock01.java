package dynamic;

/**
 * 最多只能交易1次的情况
 *
 * @author bluze
 * @see {https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/#/description}
 */
public class BestTimeBuySellStock01 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] result = new int[prices.length][3];
        result[0][0] = 0;
        result[0][1] = -prices[0];
        result[0][2] = 0;

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            result[i][0] = result[i - 1][0];
            result[i][1] = max(result[i - 1][1], result[i - 1][0] - prices[i]);
            result[i][2] = max(result[i - 1][2], result[i - 1][1] + prices[i]);
            res = max(result[i][0], result[i][1], result[i][2]);
        }

        return res;
    }

    private int max(int v1, int v2) {
        return v1 >= v2 ? v1 : v2;
    }

    private int max(int v1, int v2, int v3) {
        return v1 >= v2 ? (v1 >= v3 ? v1 : v3) : (v2 >= v3 ? v2 : v3);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeBuySellStock01 stock = new BestTimeBuySellStock01();
        System.out.println(stock.maxProfit(prices));
    }

}
