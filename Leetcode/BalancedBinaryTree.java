/**
 * Created by abhijeet on 10/31/16.
 * https://leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    public class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if(Math.abs(leftHeight - rightHeight) > 1)
                return false;
            else
                return true;
        }

        private int height(TreeNode root) {
            if (root.right == null && root.left == null) return 1;

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
