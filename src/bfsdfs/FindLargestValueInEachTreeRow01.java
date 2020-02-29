package bfsdfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * @author bluze
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        List<List<Integer>> all = new ArrayList<>();
        dfs(all, 0, root);
        for (List<Integer> each : all) {

            int max = each.get(0);
            for (int i = 1; i < each.size(); i++) {
                if(max < each.get(i)){
                    max = each.get(i);
                }
            }
            result.add(max);
        }
        return result;
    }

    private void dfs(List<List<Integer>> all, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (all.size() < level + 1) {
            all.add(new ArrayList<>());
        }

        all.get(level).add(node.val);

        dfs(all, level + 1, node.left);
        dfs(all, level + 1, node.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        FindLargestValueInEachTreeRow treeRow = new FindLargestValueInEachTreeRow();
        System.out.println(treeRow.largestValues(node));
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
