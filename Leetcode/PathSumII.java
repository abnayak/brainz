/**
 * Created by abhijeet on 2/6/16.
 * https://leetcode.com/problems/path-sum-ii/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
     5
    / \
    4   8
   /   / \
   11  13  4
  /  \    / \
  7    2  5   1
 */

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
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
    
    public static class Solution {
        private List<List<Integer>> solutions;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            solutions = new ArrayList<>();
            pathSumHelper(root, sum, new ArrayList<>());
            return solutions;
        }

        private void pathSumHelper(TreeNode root, int sum, List<Integer> solution) {
            if(root == null)
                return;


            solution.add(root.val);

            if (root.left == null && root.right == null && sum - root.val == 0) {
                List<Integer> temp = new ArrayList<>();
                for(Integer i : solution) {
                    temp.add(i);
                }
                solutions.add(temp);
            }
            pathSumHelper(root.left, sum - root.val, solution);
            pathSumHelper(root.right, sum - root.val, solution);
            solution.remove(solution.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,8,11,13,4,7,2,5,1};
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);


        Solution solution = new Solution();
        List<List<Integer>> pathSums = solution.pathSum(root, 22);

        for(int i = 0; i < pathSums.size(); i++) {
            for(int j= 0; j< pathSums.get(i).size(); j++ ) {
                System.out.print(pathSums.get(i).get(j) + ",");
            }
            System.out.println("");
        }
    }
}
