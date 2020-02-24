package tree;

public class BinaryTree {

    public void printPreOrderTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreOrderTree(root.left);
            printPreOrderTree(root.right);
        }
    }

    public void printInOrderTree(TreeNode root) {
        if (root != null) {
            printInOrderTree(root.left);
            System.out.print(root.val + " ");
            printInOrderTree(root.right);
        }
    }

    public void printPostOrderTree(TreeNode root) {
        if (root != null) {
            printPostOrderTree(root.left);
            printPostOrderTree(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.printPreOrderTree(root);
//        binaryTree.printInOrderTree(root);
        binaryTree.printPostOrderTree(root);
    }

}
