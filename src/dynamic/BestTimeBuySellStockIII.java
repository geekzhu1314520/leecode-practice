//package dynamic;

public class BestTimeBuySellStockIII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int length = prices.length;
        int[][][] result = new int[length][3][2];

        result[0][0][0] = 0;
        result[0][0][1] = -prices[0];
        result[0][1][0] = 0;
        result[0][1][1] = -prices[0];
        result[0][2][0] = 0;
        result[0][2][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            result[i][0][0] = result[i - 1][0][0];
            result[i][0][1] = max(result[i - 1][0][1], result[i - 1][0][0] - prices[i]);

            result[i][1][0] = max(result[i - 1][1][0], result[i - 1][0][1] + prices[i]);
            result[i][1][1] = max(result[i - 1][1][1], result[i - 1][1][0] - prices[i]);

            result[i][2][0] = max(result[i - 1][2][0], result[i - 1][1][1] + prices[i]);
        }

        return max(result[length - 1][0][0], result[length - 1][1][0], result[length - 1][2][0]);
    }

    private int max(int v1, int v2) {
        return v1 >= v2 ? v1 : v2;
    }

    private int max(int v1, int v2, int v3) {
        return v1 >= v2 ? (v1 >= v3 ? v1 : v3) : (v2 >= v3 ? v2 : v3);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        BestTimeBuySellStockIII stock = new BestTimeBuySellStockIII();
        System.out.println(stock.maxProfit(prices));
        System.out.println(-Integer.MAX_VALUE);
        System.out.println(-Integer.MAX_VALUE - 3);
    }

}
