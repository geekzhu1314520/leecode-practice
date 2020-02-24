package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        helper(nodes, result);
        return result;
    }

    private void helper(List<Node> nodes, List<List<Integer>> result) {
        if (nodes == null || nodes.size() == 0) {
            return;
        }

        List<Integer> each = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        for (Node node : nodes) {
            each.add(node.val);
            if (node.children != null) {
                nodeList.addAll(node.children);
            }
        }
        result.add(each);
        helper(nodeList, result);
    }

    public static void main(String[] args) {
        Node root = null;
//        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);

//        List<Node> c1 = new ArrayList<>();
//        c1.add(n1);
//        c1.add(n2);
//        c1.add(n3);
//        root.children = c1;
//
//        List<Node> c2 = new ArrayList<>();
//        c2.add(n4);
//        c2.add(n5);
//        n1.children = c2;

        NAryTreeLevelOrderTraversal orderTraversal = new NAryTreeLevelOrderTraversal();
        System.out.println(orderTraversal.levelOrder(root));
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
