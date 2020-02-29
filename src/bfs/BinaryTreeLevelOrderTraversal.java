package bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        dfs(result, root, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode node, int level) {

        if (node == null) {
            return;
        }

        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        dfs(result, node.left, level + 1);
        dfs(result, node.right, level + 1);
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        BinaryTreeLevelOrderTraversal orderTraversal = new BinaryTreeLevelOrderTraversal();
        System.out.println(orderTraversal.levelOrder(root));

    }

}
