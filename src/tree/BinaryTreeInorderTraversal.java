package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorder(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            inorder(node.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        BinaryTreeInorderTraversal inorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> result = inorderTraversal.inorderTraversal(root);
        System.out.println(result);
    }


}
