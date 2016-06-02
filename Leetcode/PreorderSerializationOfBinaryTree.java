import java.util.Stack;

/**
 * Created by abhijeet on 5/30/2016.
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * <p>
 * Example 2:
 * "1,#"
 * Return false
 * <p>
 * Example 3:
 * "9,#,#,1"
 * Return false
 * <p>
 * SOLUTION 1:
 * Total numbers of # = Total numbers of Nodes + 1 at the end of the string.
 * <p>
 * SOLUTION 2:
 * https://leetcode.com/discuss/92919/java-counting-indegree-and-outdegree-simple-%26-clear
 * In a balanced graph (in this case a binary tree) total number of in-degree = total number of out-degree
 * At a given time total
 */
public class PreorderSerializationOfBinaryTree {
    public static void main (String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization("9,9,91,#,#,9,#,49,#,#,#"));
    }

    public static class Solution {
        public boolean isValidSerialization (String preorder) {
            int selectMethod = ((int)(Math.random() * 10)) % 2;
            boolean result = false;
            switch(selectMethod) {
                case 0:
                    result = InDegreeOutDegreeMethod(preorder);
                    break;
                case 1:
                    result = InDegreeOutDegreeMethod(preorder);
                    break;
            }
            return result;
        }

        private boolean stackMethod(String preorder) {
            String[] strings = preorder.split(",");
            Stack<String> stack = new Stack<>();
            int count = 0;
            for (String string : strings) {
                count++;
                if (!string.equals("#")) {
                    stack.push(string);
                } else {
                    // # is the last and there is no element left in the stack, that means we reached the end of the string
                    if (count == strings.length && stack.size() == 0) {
                        return true;
                    } else if (count != strings.length && stack.size() == 0) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return false;
        }

        public boolean InDegreeOutDegreeMethod (String preorder) {
            int inDegree = -1;
            String[] strings = preorder.split(",");
            for (String string : strings) {
                inDegree++;

                if(inDegree >0) {
                    return false;
                }

                if(!string.equals("#")) {
                    inDegree = inDegree-2;
                }
            }
            return inDegree == 0;
        }
    }
}
