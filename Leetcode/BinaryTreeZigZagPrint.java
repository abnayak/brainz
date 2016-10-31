import java.util.*;

/**
 * Created by abhijeet on 10/23/16.
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigZagPrint {
    public static void main(String[] args) {

    }

    public class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            if(root == null) return result;

            stack1.add(root);
            while(!stack1.isEmpty() || !stack2.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                if(!stack1.isEmpty()) {
                    while(!stack1.isEmpty()) {
                        TreeNode temp = stack1.pop();
                        if(temp.left != null) stack2.push(temp.left);
                        if(temp.right != null) stack2.push(temp.right);
                        list.add(temp.val);
                    }
                    result.add(list);
                } else {
                    while(!stack2.isEmpty()) {
                        TreeNode temp = stack2.pop();
                        if(temp.right != null) stack1.push(temp.right);
                        if(temp.left != null) stack1.push(temp.left);
                        list.add(temp.val);
                    }
                    result.add(list);
                }
            }
            return result;
        }
    }
}
