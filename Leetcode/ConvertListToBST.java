import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 10/25/2016.
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertListToBST {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        one.next = new ListNode(3);
        Solution solution = new Solution();
        solution.sortedListToBST(one);
    }
    public static class Solution {
        TreeNode root = null;

        public TreeNode sortedListToBST(ListNode head) {
            ArrayList<Integer> list = new ArrayList<>();

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            buildBST(list, 0, list.size()-1);
            return root;
        }

        private void buildBST(List<Integer> list, int begin, int end) {
            if (begin <= -1 || begin >= list.size()) return;
            if (end <= -1 || end >= list.size()) return;
            if(begin > end) return;

            int mid = (begin + end) / 2;
            root = addToBST(list.get(mid), root);
            buildBST(list, begin, mid - 1 );
            buildBST(list, mid + 1 , end);
        }

        private TreeNode addToBST(int value, TreeNode root) {
            if (root == null) {
                root = new TreeNode(value);
                root.left = null;
                root.right = null;
                return root;
            } else {
                if (value <= root.val) {
                    root.left = addToBST(value, root.left);
                } else {
                    root.right = addToBST(value, root.right);
                }
                return root;
            }
        }
    }
}
