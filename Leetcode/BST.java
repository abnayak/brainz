/**
 * Created by abhijeen on 1/17/16.
 */

public class BST {
    private TreeNode root = null;

    public static class TreeNode {
        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode addNodes(int[] nums) {
        for(int i: nums)
            addNode(i);

        return root;
    }

    private void addNode(int val) {
        if (root == null) {
            root = createNode(val);
        } else {
            addNodeHelper(root, val);
        }
    }

    private void addNodeHelper(TreeNode node, int val) {
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

    private void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.println(root.val);
        printInOrder(root.right);
    }

    public static TreeNode createNode(int val) {
        return new TreeNode(val);
    }
}
