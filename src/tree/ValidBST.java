package tree;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }

        if (max != null && root.val >= max) {
            return false;
        }

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static void main(String[] args) {
        ValidBST validBST = new ValidBST();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(6);
//        TreeNode node4 = new TreeNode(20);
        root.left = node1;
//        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;

//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(1);
//        root.left = node1;
        System.out.println(validBST.isValidBST(root));
    }

}
