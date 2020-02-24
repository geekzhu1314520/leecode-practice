package dynamic;

public class BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeBuySellStock stock = new BestTimeBuySellStock();
        System.out.println(stock.maxProfit(prices));
    }

}
