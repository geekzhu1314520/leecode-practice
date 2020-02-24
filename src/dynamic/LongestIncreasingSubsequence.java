package dynamic;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 1;

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        System.out.println(subsequence.lengthOfLIS(nums));
    }

}
