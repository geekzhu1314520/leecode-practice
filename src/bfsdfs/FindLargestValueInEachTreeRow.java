package bfsdfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, 0, root);
        return result;
    }

    private void dfs(List<Integer> result, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(Integer.MIN_VALUE);
        }

        result.set(level, Math.max(result.get(level), node.val));

        dfs(result, level + 1, node.left);
        dfs(result, level + 1, node.right);
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
