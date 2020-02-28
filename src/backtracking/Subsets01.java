package backtracking;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/subsets
 */
public class Subsets01 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        dfs(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int index, ArrayList<Integer> path) {

        //终止条件
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        //分治1：不需要当前节点
        dfs(result, nums, index + 1, path);

        //分治2：需要当前节点
        path.add(nums[index]);
        dfs(result, nums, index + 1, path);

        //状态恢复
        path.remove(path.size() - 1);

    }


    public static void main(String[] args) {
        Subsets01 subsets = new Subsets01();
        int[] nums = new int[]{3, 2, 1};
        System.out.println(subsets.subsets(nums));
    }

}
