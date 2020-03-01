package binarysearch;

public class FindHalfOrderIndex {

    public int findHalfOrder(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int left, int right) {
        int middle = left + (right - left) / 2;

        //情况1，要找的值在middle的右半部分
        if (nums[middle] > nums[left] && nums[middle] > nums[right]) {
            if (middle + 1 < nums.length && nums[middle + 1] < nums[middle]) {
                return middle + 1;
            }
            return find(nums, middle + 1, right);
        }

        //情况2，要找的值，middle的左半部分
        if (nums[middle] < nums[left] && nums[middle] < nums[right]) {
            if (middle - 1 > 0 && nums[middle - 1] > nums[middle]) {
                return middle;
            }
            return find(nums, left + 1, middle);
        }

        //情况3，不确定在左或在右
        if (nums[middle] > nums[left] && nums[middle] < nums[right]) {
            while (left - 1 >= 0) {
                if (nums[left] < nums[left - 1]) {
                    return left;
                }
            }

            while (right + 1 < nums.length) {
                if (nums[right] > nums[right + 1]) {
                    return right + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 0, 1, 2, 3};
        FindHalfOrderIndex orderIndex = new FindHalfOrderIndex();
        System.out.println(orderIndex.findHalfOrder(nums));
    }

}
