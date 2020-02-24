package recursion;

import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = nums[0];
        map.put(max, 1);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            Integer value = map.get(num);
            value = value == null ? 1 : value + 1;
            if (value > nums.length / 2) {
                max = num;
                break;
            }
            map.put(num, value);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
//        int[] nums = new int[]{3, 2, 3};


        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(nums));

    }

}
