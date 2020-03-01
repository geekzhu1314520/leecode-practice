package greedy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        if (g == null || s == null) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        int count = 0;
        for (int i = 0; i < g.length; i++) {
            while (index < s.length && s[index] < g[i]) {
                index++;
            }

            if (index == s.length) {
                break;
            }

            if (s[index] >= g[i]) {
                count++;
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{2, 1};

        AssignCookies assignCookies = new AssignCookies();
        System.out.println(assignCookies.findContentChildren(g, s));
    }

}
