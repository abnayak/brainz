import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by abhijeet on 10/20/16.
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }

    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> inOrderResult = new ArrayList<>();

            if (root == null) {
                return inOrderResult;
            }
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                if(top.left == null && top.right == null) {
                    inOrderResult.add(top.val);
                } else {
                    if(top.right != null) stack.push(top.right);
                    TreeNode leftNode = top.left;
                    top.left = null;
                    top.right = null;
                    stack.push(top);
                    if(leftNode != null) stack.push(leftNode);
                }
            }
            return inOrderResult;
        }
    }
}
