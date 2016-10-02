package LinkedList;

/**
 * Created by abhijeet on 10/1/16.
 */
public class RotateAList {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {
        public ListNode rotateRight(ListNode a, int b) {
            java.util.Deque<ListNode> queue = new java.util.LinkedList<>();

            while (a != null) {
                queue.addLast(a);
                a = a.next;
            }

            b = b % queue.size();
            ListNode root = null;
            for (int i = 0; i < b; i++) {
                if(root == null) {
                    root = queue.removeLast();
                    root.next = null;
                } else {
                    queue.peekLast().next = root;
                    root = queue.removeLast();
                }
            }

            a = root;
            while(root != null && root.next != null) {
                root = root.next;
            }

            while(!queue.isEmpty()) {
                if(root == null) {
                    root = queue.removeFirst();
                    root.next = null;
                } else {
                    root.next = queue.removeFirst();
                    root = root.next;
                    root.next = null;
                }
            }
            return a;
        }
    }

}
