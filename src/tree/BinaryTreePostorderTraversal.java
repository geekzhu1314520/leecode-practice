package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postorder(node.left, result);
        }
        if (node.right != null) {
            postorder(node.right, result);
        }
        result.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        BinaryTreePostorderTraversal postorderTraversal = new BinaryTreePostorderTraversal();
        List<Integer> result = postorderTraversal.postorderTraversal(root);
        System.out.println(result);
    }

}
