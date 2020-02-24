package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {

    private List<List<Integer>> result;
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.result = new ArrayList<>();
        this.n = n;
        this.k = k;
        backtrack(1, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, List<Integer> cur) {
        if (cur.size() == k) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            backtrack(i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.combine(4, 3);
        System.out.println(result);
    }

}
