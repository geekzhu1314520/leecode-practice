package array;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length; j++) {
            if (nums[i] == 0) {
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                if (j == nums.length) {
                    break;
                }
                swap(nums, i, j);
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(nums);
    }

}
