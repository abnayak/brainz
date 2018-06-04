public class SymmetricTree {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root.left == null && root.right == null) {
                return true;
            }
            if (root.left != root.right) {
                return false;
            }

            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left.left == right.right && left.right == right.left) {
                return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            }

            return false;
        }
    }
}
