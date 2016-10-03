package LinkedList;

/**
 * Created by abhijeet on 10/1/16.
 */
public class SwapListNodesInPair {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode three = new ListNode(3);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode result = solution.swapPairs(one);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static class Solution {
        public ListNode swapPairs(ListNode a) {
            ListNode previous = null;
            ListNode current = a;
            ListNode next;
            while(current != null && current.next != null) {
                if(current == a) {
                    a = current.next;
                    previous = current;
                    current = a.next;
                    a.next = previous;
                    previous.next = current;
                } else {
                    next = current.next.next;
                    previous.next = current.next;
                    previous.next.next = current;
                    current = next;
                    previous.next.next.next = current;
                    previous = previous.next.next;
                }
            }
            return a;
        }
    }
}
