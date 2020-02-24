package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence01 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = lowerBound(res, res.size(), nums[i]);
            if (index == res.size()) {
                res.add(nums[i]);
            } else {
                res.set(index, nums[i]);
            }
        }
        return res.size();
    }

    private int lowerBound(List<Integer> list, int size, int num) {
        int first = 0;
        int last = size;
        int pos = 0;
        int middle;

        while (first < last) {
            middle = (first + last) / 2;
            if (list.get(middle) < num) {
                first = middle + 1;
                pos = first;
            } else {
                last = middle;
                pos = last;
            }
        }
        return pos;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence01 subsequence = new LongestIncreasingSubsequence01();
        System.out.println(subsequence.lengthOfLIS(nums));
    }

}
