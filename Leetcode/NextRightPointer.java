/**
 * Created by abhijeet on 5/24/2016.
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */

public class NextRightPointer {
    public static void main (String[] args) {

    }

    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     * int val;
     * TreeLinkNode left, right, next;
     * TreeLinkNode(int x) { val = x; }
     * }
     */
    public static class Solution {
        public static void connect (TreeLinkNode root) {
            if (root == null) return;

            root.next = null;
            setRightpointer(root, null);
        }

        public static void setRightpointer (TreeLinkNode root, TreeLinkNode rightSibling) {
            if (root == null)
                return;

            // Set next pointer between the left and right children
            if (root.left != null) {
                root.left.next = root.right;
            }

            // Set the next pointer of right child to rightSubling's left child
            if (root.right != null) {
                if (rightSibling != null) {
                    root.right.next = rightSibling.left;
                } else {
                    root.right.next = null;
                }
            }

            // Traverse the left subtree
            setRightpointer(root.left, root.right);

            // Traverse the right subtree
            if(rightSibling != null) {
                setRightpointer(root.right, rightSibling.left);
            } else {
                setRightpointer(root.right, null);
            }

        }
    }

    public static class TreeLinkNode {
        TreeLinkNode left, right, next;
        int val;
    }
}
