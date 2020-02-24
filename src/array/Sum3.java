package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                Integer value = map.get(-key);
                if (value != null) {
                    List<Integer> each = new ArrayList();
                    each.add(i);
                    each.add(j);
                    each.add(value);
                    result.add(each);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new Sum3().threeSum(nums);
        System.out.println(result);
    }

}
