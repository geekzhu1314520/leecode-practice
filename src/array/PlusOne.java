package array;

/**
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        System.arraycopy(digits, 0, res, 0, digits.length);

        int value = (res[digits.length - 1] + 1) % 10;
        if (value == 0) {
            boolean isOverFlow = plus(res, digits.length - 1);
            if (isOverFlow) {
                res = new int[digits.length + 1];
                res[0] = 1;
            }
        } else {
            res[digits.length - 1] = value;
        }
        return res;
    }

    private boolean plus(int[] nums, int i) {
        if (i < 0) {
            return true;
        }
        nums[i] = (nums[i] + 1) % 10;
        if (nums[i] > 0) {
            return false;
        }
        return plus(nums, i - 1);
    }

    public static void main(String[] args) {
        int[] digits = new int[]{8, 9, 9};
        PlusOne plusOne = new PlusOne();
        int[] res = plusOne.plusOne(digits);
    }

}
