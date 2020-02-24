package dynamic;

public class BestTimeBuySellStockIII01 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int release1 = 0;
        int release2 = 0;
        int hold1 = Integer.MIN_VALUE;
        int hold2 = Integer.MIN_VALUE;

        for (int price : prices) {
            release2 = max(release2, hold2 + price);
            release1 = max(release1, hold1 + price);
            hold1 = max(hold1, - price);
            hold2 = max(hold2, release1 - price);
        }

        return release2;
    }

    private int max(int v1, int v2) {
        return v1 >= v2 ? v1 : v2;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        BestTimeBuySellStockIII01 stock = new BestTimeBuySellStockIII01();
        System.out.println(stock.maxProfit(prices));
    }

}
