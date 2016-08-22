/**
 * Created by abhijeet on 8/18/16.
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and
 * each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = (new ListNode(2));
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = (new ListNode(5));
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = Solution.addTwoNumbers(l1,l2);
        while(result != null) {
            System.out.println(result.val);
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
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = null;
            ListNode returnResult = null;

            if(l1 == null) {
                return l2;
            }
            if(l2 == null) {
                return l1;
            }
            int carry = 0;
            while(l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                carry =0;
                if(sum >=10) {
                    carry = 1;
                    sum %= 10;
                }

                // Create the new node and add it to the result
                ListNode newNode = new ListNode(sum);
                if(result == null) {
                    result = newNode;
                    returnResult = result;
                } else {
                    result.next = newNode;
                    result = result.next;
                }

                l1 = l1.next;
                l2 = l2.next;
            }

            // If any elements left in l1
            while(l1 != null) {
                int sum = l1.val + carry;
                carry =0;
                if(sum >10) {
                    carry = 1;
                    sum %= 10;
                }
                ListNode newNode = new ListNode(sum);
                result.next = newNode;
                result = result.next;
                l1 = l1.next;
            }

            // If any elements left in l2
            while(l2 != null) {
                int sum = l2.val + carry;
                carry =0;
                if(sum >10) {
                    carry = 1;
                    sum %= 10;
                }
                ListNode newNode = new ListNode(sum);
                result.next = newNode;
                result = result.next;
                l2 = l2.next;
            }

            // add carry if not equals to zero
            if(carry != 0) {
                ListNode newNode = null;
                if(carry >=10) {
                    newNode = new ListNode(carry % 10);
                    result.next = newNode;
                    result.next.next = new ListNode(1);
                } else {
                    newNode = new ListNode(carry);
                    result.next = newNode;
                }
            }
            return returnResult;
        }
    }
}
