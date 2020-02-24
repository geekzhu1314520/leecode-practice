package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = length - 1;
            Integer ivalue = nums[i];
            while (j < k) {
                Integer jvalue = nums[j];
                Integer kvalue = nums[k];
                if (ivalue + jvalue + kvalue == 0) {
                    List each = new ArrayList<Integer>();
                    each.add(ivalue);
                    each.add(jvalue);
                    each.add(kvalue);
                    result.add(each);
                    while (j < k && jvalue == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && kvalue == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (ivalue + jvalue + kvalue > 0) {
                    k--;
                } else if (ivalue + jvalue + kvalue < 0) {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> result = threeSum.threeSum(nums);

    }

}
