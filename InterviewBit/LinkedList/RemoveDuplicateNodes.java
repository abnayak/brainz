package LinkedList;

import java.util.Stack;

/**
 * Created by abhijeet on 9/29/16
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        // 1->2->3->3->4->4->5
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);

        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(root);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static class Solution {
        public ListNode deleteDuplicates(ListNode a) {
            if (a == null) return a;
            Stack<ListNode> stack = new Stack<ListNode>();

            while (a != null) {
                // check if the top element in the stack does not match with current element
                if (stack.size() == 0 || stack.peek().val != a.val) {
                    stack.push(a);
                    a = a.next;
                } else { // top of stack match with current element
                    while (a != null && a.val == stack.peek().val) a = a.next;
                    stack.pop();
                }
            }

            // Now build the solution
            while (!stack.isEmpty()) {
                if (a == null) {
                    a = stack.pop();
                    a.next = null;
                } else {
                    stack.peek().next = a;
                    a = stack.pop();
                }
            }
            return a;
        }
    }
}
