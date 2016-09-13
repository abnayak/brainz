/**
 * Created by abhijeet on 9/12/16.
 */
public class RemoveNthNodeFromLast {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = null;
        three.next = four;
        four.next = five;
        five.next = null;

        Solution solution = new Solution();
        ListNode result = solution.removeNthFromEnd(one, 1);
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
        }
    }

    public static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if(head == null ) return null;

            int listLen = 0;
            ListNode temp = head;
            while(temp != null) {
                listLen++;
                temp = temp.next;
            }

            if(n > listLen) return null;
            ListNode back = head;
            ListNode front = head;
            while(n != 0) {
                front = front.next;
                n--;
            }

            ListNode backBack = head;
            while(front != null) {
                backBack = back;
                front = front.next;
                back = back.next;
            }

            if(back == head) {
                head = head.next;
            } else {
                backBack.next = back.next;
            }

            return head;
        }
    }
}

