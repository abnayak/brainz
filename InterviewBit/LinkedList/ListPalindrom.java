package LinkedList;

/**
 * Created by abhijeet on 10/1/16.
 */
public class ListPalindrom {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(2);
        ListNode five = new ListNode(1);

        one.next = two;
//        two.next = three;
//         three.next = four;
//        four.next = five;

        System.out.println(solution.lPalin(one));

    }

    public static class Solution {
        public int lPalin(ListNode A) {
            if(A.next == null) return 1;

            ListNode temp = A;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            int mid = count % 2 == 0 ? count / 2 : (count / 2) + 1;
            temp = A;
            // reverse B
            ListNode previous = null;
            ListNode next = null;

            while (mid > 0) {
                mid--;
                previous = temp;
                temp = temp.next;
            }

            ListNode B = temp;
            previous.next = null;

            previous = null;
            while (B != null) {
                next = B.next;
                B.next = previous;
                previous = B;
                B = next;
            }
            while(previous != null) {
                if(previous.val == A.val) {
                    previous = previous.next;
                    A = A.next;
                } else {
                    return 0;
                }
            }
            if(previous == null) return 1;

            return 0;
        }
    }
}
