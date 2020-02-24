package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/description/
 */
public class Triangle01 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int levels = triangle.size();
        int[] sum = new int[levels];

        for (int j = 0; j < levels; j++) {
            sum[j] = triangle.get(levels - 1).get(j);
        }

        for (int i = levels - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int value1 = sum[j] + triangle.get(i).get(j);
                int value2 = sum[j + 1] + triangle.get(i).get(j);
                sum[j] = value1 < value2 ? value1 : value2;
            }
        }

        return sum[0];
    }

    public static void main(String[] args) {

        List<Integer> a1 = new ArrayList<Integer>() {{
            add(2);
        }};

        List<Integer> a2 = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};

        List<Integer> a3 = new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }};

        List<Integer> a4 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};

        List<List<Integer>> arr = new ArrayList<List<Integer>>() {{
            add(a1);
            add(a2);
            add(a3);
            add(a4);
        }};

        Triangle01 triangle = new Triangle01();
        System.out.println(triangle.minimumTotal(arr));
    }

}
