import LinkedList.Reverse;

import java.util.Stack;

/**
 * Created by abhijeet on 9/1/16.
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        ListNode result = solution.reverseKGroup(root, 6);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {

        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            if (k == 0 || k == 1) {
                return head;
            }

            ListNode root = null;
            ListNode tail = null;

            Stack<ListNode> stack = new Stack<>();
            while (head != null) {
                for (int i = 1; i <= k && head != null; i++) {
                    stack.push(head);
                    head = head.next;
                }
                if (stack.size() == k) {
                    while (!stack.isEmpty()) {
                        if (root == null) {
                            root = stack.pop();
                            tail = root;
                            tail.next = null;
                        } else {
                            tail.next = stack.pop();
                            tail = tail.next;
                            tail.next = null;
                        }
                    }
                } else {
                    Stack<ListNode> temp = new Stack<>();
                    while (!stack.isEmpty()) {
                        temp.push(stack.pop());
                    }
                    while (!temp.isEmpty()) {
                        if (root == null) {
                            root = temp.pop();
                            tail = root;
                            tail.next = null;
                        } else {
                            tail.next = temp.pop();
                            tail = tail.next;
                            tail.next = null;
                        }
                    }
                }
            }

            return root;
        }
    }
}
