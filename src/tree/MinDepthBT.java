package tree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
public class MinDepthBT {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return 1 + Math.min(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;

        MinDepthBT maxDepthBT = new MinDepthBT();
        System.out.println(maxDepthBT.minDepth(root));
    }

}
