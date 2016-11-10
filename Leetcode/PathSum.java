/**
 * Created by abhijeet on 10/31/16.
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null && sum == 0) return true;
        if (sum == 0 || sum < 0 || sum < root.val || root == null) return false;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
