package bfsdfs;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * @author bluze
 */
public class FindLargestValueInEachTreeRow01 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            int size = deque.size();

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    deque.addLast(node.left);
                }

                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }

            result.add(max);
        }

        return result;
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

        FindLargestValueInEachTreeRow01 treeRow = new FindLargestValueInEachTreeRow01();
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
