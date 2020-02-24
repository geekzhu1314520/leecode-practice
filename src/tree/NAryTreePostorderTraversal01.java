package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 */
public class NAryTreePostorderTraversal01 {

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.addFirst(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);

        List<Node> c1 = new ArrayList<>();
        c1.add(n1);
        c1.add(n2);
        c1.add(n3);
        root.children = c1;

        List<Node> c2 = new ArrayList<>();
        c2.add(n4);
        c2.add(n5);
        n1.children = c2;

        NAryTreePostorderTraversal01 traversal = new NAryTreePostorderTraversal01();
        System.out.println(traversal.postorder(root));
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

    ;

}
