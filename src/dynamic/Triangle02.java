package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle
 */
public class Triangle02 {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int m = triangle.size();
        int[] dp = new int[m];

        for (int i = 0; i < m; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle02 triangle02 = new Triangle02();
        List<Integer> t1 = new ArrayList<Integer>() {{
            add(2);
        }};

        List<Integer> t2 = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};

        List<Integer> t3 = new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }};

        List<Integer> t4 = new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }};

        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {{
            add(t1);
            add(t2);
            add(t3);
            add(t4);
        }};

        System.out.println(triangle02.minimumTotal(triangle));

    }

}
