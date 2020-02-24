package array;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/submissions/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while (left < right) {
            int minHeight = height[left] <= height[right] ? height[left++] : height[right--];
            int area = (right - left + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

}
