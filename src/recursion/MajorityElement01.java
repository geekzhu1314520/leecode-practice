package recursion;

public class MajorityElement01 {

    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }

        }
        return major;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 1, 1, 2, 2};

//        int[] nums = new int[]{3, 2, 3};


        MajorityElement01 majorityElement = new MajorityElement01();
        System.out.println(majorityElement.majorityElement(nums));

    }

}
