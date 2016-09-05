package LinkedList;

/**
 * Created by abhijeet on 8/31/16.
 * Reverse a given linked list
 * <p>
 * Input
 * 1->2->3->4
 * <p>
 * Output
 * 4->3->2->1
 */
public class Reverse {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;

        ListNode reversed = reverse(first);
        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
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


    private static ListNode reverse(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode back = null;
        ListNode front = root;

        while (front != null) {
            ListNode temp = front.next;
            front.next = back;
            back = front;
            front = temp;
        }

        return back;
    }
}
