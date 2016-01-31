/**
 * Created by abhijeen on 1/17/16.
 */
public class BST {
    private static Node root = null;

    public static class Node {
        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public int val;
        public Node left;
        public Node right;
    }

    private static void addNode(int val) {
        if (root == null) {
            root = createNode(val);
        } else {
            addNodeHelper(root, val);
        }
    }

    private static void addNodeHelper(Node node, int val) {
        if (val >= node.val) {
            if (node.right == null) {
                node.right = createNode(val);
            } else {
                addNodeHelper(node.right, val);
            }
        } else if (val < node.val) {
            if (node.left == null) {
                node.left = createNode(val);
            } else {
                addNodeHelper(node.left, val);
            }
        }
    }

    private static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.println(root.val);
        printInOrder(root.right);
    }

    private static Node createNode(int val) {
        return new Node(val);
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 6, 2, 8, 4};
        for (int i : array)
            addNode(i);
        printInOrder(root);
    }
}
