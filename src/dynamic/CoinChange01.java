package dynamic;

public class CoinChange01 {

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

        CoinChange01 change01 = new CoinChange01();
        System.out.println(change01.coinChange(coins, amount));
    }

}
