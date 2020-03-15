package dynamic;

public class MaximumProductSubarray01 {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        //dp[i][0]包含nums[i]的最大值，dp[i][1]包含nums[i]的最小值
        int result = dp[0][0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
            } else if (nums[i] < 0) {
                dp[i][0] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            }
            result = Math.max(result, dp[i][0]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, -1};
        MaximumProductSubarray01 subarray01 = new MaximumProductSubarray01();
        System.out.println(subarray01.maxProduct(nums));
    }

}
