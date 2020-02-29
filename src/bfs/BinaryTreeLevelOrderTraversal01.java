package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */
public class BinaryTreeLevelOrderTraversal01 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            List<Integer> each = new ArrayList<>();
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.poll();
                each.add(node.val);

                if (node.left != null) {
                    deque.addLast(node.left);
                }

                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            result.add(each);
        }

        return result;
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

        BinaryTreeLevelOrderTraversal01 orderTraversal = new BinaryTreeLevelOrderTraversal01();
        System.out.println(orderTraversal.levelOrder(root));

    }

}
