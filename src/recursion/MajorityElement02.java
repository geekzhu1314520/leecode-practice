package recursion;

import java.util.Arrays;

public class MajorityElement02 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 2, 1, 1, 2, 2};
        int[] nums = new int[]{3, 2, 3};

        MajorityElement02 majorityElement = new MajorityElement02();
        System.out.println(majorityElement.majorityElement(nums));

    }

}
