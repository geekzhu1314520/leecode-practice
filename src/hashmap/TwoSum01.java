package hashmap;

import java.util.HashSet;

public class TwoSum01 {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return new int[]{};
        }

        int[] ret = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (set.contains(value) && target == value << 1) {
                ret[1] = i;
                for (int j = 0; j < i; j++) {
                    if (nums[j] == value) {
                        ret[0] = j;
                    }
                }
                return ret;
            }
            set.add(value);
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int targetValue = target - value;
            if (set.contains(targetValue) && value != targetValue) {
                ret[index++] = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int[] nums = {3, 3};
        int[] nums = {3, 2, 4};
        int target = 6;
        TwoSum01 twoSum = new TwoSum01();
        int[] ret = twoSum.twoSum(nums, target);
        for (int i : ret) {
            System.out.println(i);
        }
    }

}
