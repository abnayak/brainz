package LinkedList;

import java.util.Stack;

/**
 * Created by abhijeet on 10/1/16.
 * https://www.interviewbit.com/problems/reverse-link-list-ii/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list. Note 2:
 Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.

 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        Solution solution = new Solution();
        ListNode listnode = solution.reverseBetween(one, 2,5 );
        while(listnode != null) {
            System.out.println(listnode.val);
            listnode = listnode.next;
        }
    }

    public static class Solution {
        public ListNode reverseBetween(ListNode a, int m, int n) {
            Stack<ListNode> stack = new Stack<>();

            int count =1 ;
            ListNode previous = null;
            ListNode present = a;
            while(count < m) {
                previous = present;
                present = present.next;
                count++;
            }

            while(count <= n) {
                stack.push(present);
                present = present.next;
                count++;
            }

            while(!stack.isEmpty()) {
                if(previous != null) {
                    stack.peek().next = null;
                    previous.next = stack.pop();
                    previous = previous.next;
                } else  {
                    previous = stack.pop();
                    previous.next = null;
                    a = previous;
                }
            }

            previous.next = present;

            return a;
        }
    }

}
