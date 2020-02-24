package backtracking;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/subsets
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        dfs(nums, 0, nums.length, new ArrayDeque<>(), result);

        return result;
    }

    private void dfs(int[] nums, int depth, int length, Deque<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));
        for (int i = depth; i < length; i++) {
            path.addLast(nums[i]);
            dfs(nums, i + 1, length, path, result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = new int[]{3, 2, 1};
        System.out.println(subsets.subsets(nums));
    }

}
