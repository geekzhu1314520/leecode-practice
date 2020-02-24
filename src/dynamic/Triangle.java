package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/description/
 */
public class Triangle {

    List<Integer> result = new ArrayList<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        minimum(triangle, 0, 0, 0);
        int min = Integer.MAX_VALUE;
        for (Integer value : result) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private void minimum(List<List<Integer>> triangle, int i, int j, int sum) {
        if (i >= triangle.size()) {
            result.add(sum);
            return;
        }
        sum += triangle.get(i).get(j);
        minimum(triangle, i + 1, j, sum);
        minimum(triangle, i + 1, j + 1, sum);
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

        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(arr));
    }

}
