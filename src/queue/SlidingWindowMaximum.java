package deque;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[]{};
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        if (nums.length <= k) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
            return new int[]{max};
        }

        int retLength = nums.length - (k - 1);
        int[] retArr = new int[retLength];

        for (int i = k; i <= nums.length; i++) {
            if (i == k) {
                for (int j = i - k; j < i; j++) {
                    queue.offer(nums[j]);
                }
            } else {
                queue.remove(nums[i - k - 1]);
                queue.offer(nums[i - 1]);
            }
            retArr[i - k] = queue.peek();
        }
        return retArr;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1, -1};
        int k = 1;

        SlidingWindowMaximum maximum = new SlidingWindowMaximum();
        int[] ret = maximum.maxSlidingWindow(nums, k);
        System.out.println(ret);
    }
}
