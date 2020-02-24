package tree;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0) {
            return null;
        }

        if (inorder.length == 0) {
            return null;
        }

        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        int value = preorder[0];
        int index = find(inorder, value);
        TreeNode root = new TreeNode(value);
        if (index + 1 <= preorder.length && index > 0) {
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                    Arrays.copyOfRange(inorder, 0, index));
        }
        if (index + 1 < preorder.length) {
            root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                    Arrays.copyOfRange(inorder, index + 1, inorder.length));
        }
        return root;
    }

    private int find(int[] inorder, int value) {
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{2, 3, 1};

        ConstructBinaryTreeFromPreorderAndInorderTraversal tree = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = tree.buildTree(preorder, inorder);
    }

}
