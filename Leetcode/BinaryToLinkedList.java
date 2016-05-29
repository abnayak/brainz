/**
 https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

 Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1-2-3-4-5-6
 */
public class BinaryToLinkedList {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        Solution.flatten(root);
    }

    public static class Solution {
        public static TreeNode previous = null;
        public static void flatten(TreeNode root) {
            flattenHelper(root);
        }

        public static void flattenHelper(TreeNode root) {
            if(root == null)
                return;

            flattenHelper(root.right);

            root.right = previous;
            previous = root;

            flattenHelper(root.left);
        }
    }

    public static class TreeNode {
        TreeNode left, right;
        int val;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
