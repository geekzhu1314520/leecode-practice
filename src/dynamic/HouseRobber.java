package dynamic;

/**
 * https://leetcode-cn.com/problems/house-robber
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int result = dp[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            result = Math.max(dp[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(robber.rob(nums));
    }

}
