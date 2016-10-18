import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by abhijeet on 10/15/16.
 * https://leetcode.com/problems/partition-list/
 */
public class PatitionList {
    public class Solution {
        public ListNode partition(ListNode head, int x) {
            Deque<ListNode> queue = new LinkedList<>();
            Stack<ListNode> tempStore = new Stack<>();

            while (head != null) {
                if (head.val >= x) {
                    queue.addLast(head);
                } else {
                    while (!queue.isEmpty() && queue.peekLast().val >= x) {
                        tempStore.push(queue.removeLast());
                    }
                    queue.addLast(head);
                    // Move the content of the tempStore to main stack
                    while (!tempStore.isEmpty()) {
                        queue.addLast(tempStore.pop());
                    }
                }
                head = head.next;
            }

            ListNode tail = null;
            while (!queue.isEmpty()) {
                if(head == null) {
                    head = queue.removeFirst();
                    tail = head;
                    tail.next = null;
                } else {
                    tail.next = queue.removeFirst();
                    tail.next = null;
                    tail = tail.next;
                }
            }
            return head;
        }
    }
}
