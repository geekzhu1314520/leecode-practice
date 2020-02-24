package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class SlidingWindowMaximum01 {


    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[]{};
        }

        int retLength = nums.length - (k - 1);
        int[] res = new int[retLength];
        int index = 0;

        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && window.peek() <= i - k) {
                window.poll();
            }

            while (window.size() != 0 && nums[window.getLast()] <= nums[i]) {
                window.removeLast();
            }
            window.add(i);
            if (i >= k - 1) {
                res[index++] = nums[window.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1, -1};
//        int[] nums = {7, 2, 4};
//        int[] nums = {1,3,1,2,0,5};
        int k = 3;

        SlidingWindowMaximum01 maximum = new SlidingWindowMaximum01();
        int[] ret = maximum.maxSlidingWindow(nums, k);
        System.out.println(ret);
    }
}
