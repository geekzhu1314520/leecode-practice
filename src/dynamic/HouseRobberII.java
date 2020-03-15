package dynamic;

/**
 * https://leetcode-cn.com/problems/house-robber-ii
 */
public class HouseRobberII {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        // dp[i][0]不带第一个节点；dp[i][1]带第一个节点
        int result = Math.max(dp[1][0], dp[1][1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
            if ((i + 1) % nums.length != 0) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
            }
            result = Math.max(result, dp[i][0] > dp[i][1] ? dp[i][0] : dp[i][1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        HouseRobberII robberII = new HouseRobberII();
        System.out.println(robberII.rob(nums));
    }
}
