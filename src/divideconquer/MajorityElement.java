package divideconquer;

/**
 * https://leetcode-cn.com/problems/majority-element
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        return majority(nums, 0, nums.length - 1);
    }

    private int majority(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }

        int middle = low + (high - low) / 2;
        int left = majority(nums, low, middle);
        int right = majority(nums, middle + 1, high);

        if (left == right) {
            return left;
        }

        int leftCnt = countInRange(nums, left, low, high);
        int rightCnt = countInRange(nums, right, low, high);

        return leftCnt > rightCnt ? left : right;
    }

    private int countInRange(int[] nums, int value, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == value) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(element.majorityElement(nums));
    }

}
