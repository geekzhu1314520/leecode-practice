package dynamic;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int[][] result = new int[length][2];
        result[0][0] = nums[0];
        result[0][1] = nums[0];

        for (int i = 1; i < length; i++) {
            int product = nums[i];
            int max = product, min = product;
            int value1 = product * result[i - 1][0];
            int value2 = product * result[i - 1][1];
            if (product > 0) {
                max = value1 > max ? value1 : max;
                min = value2 < min ? value2 : min;
            } else if (product < 0) {
                max = value2 > max ? value2 : max;
                min = value1 < min ? value1 : min;
            }
            result[i][0] = max;
            result[i][1] = min;
        }

        int retValue = result[0][0];
        for (int i = 0; i < result.length; i++) {
            if (result[i][0] > retValue) {
                retValue = result[i][0];
            }
        }

        return retValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        MaximumProductSubarray subarray = new MaximumProductSubarray();
        System.out.println(subarray.maxProduct(nums));
    }

}
