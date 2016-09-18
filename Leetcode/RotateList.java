/**
 * Created by abhijeet on 9/18/16.
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;

        Solution solution = new Solution();
        solution.rotateRight(first, 1);
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) return null;
            ListNode front = head;
            ListNode back = head;
            ListNode previousOfBack = null;

            // count the number of elements in the list
            ListNode temp = head;
            int count = 0;
            while(temp != null) {
                count++;
                temp = temp.next;
            }

            if(k == count || k == 0) return null;
            if(k > count) k %= count;

            while (k > 0) {
                front = front.next;
                k--;
            }

            while (front != null) {
                previousOfBack = back;
                back = back.next;
                front = front.next;
            }

            if(previousOfBack == null) return head;

            previousOfBack.next = null;

            ListNode tail = back;
            while(tail.next != null) {
                tail = tail.next;
            }

            tail.next = head;
            head = back;

            return head;
        }
    }
}
