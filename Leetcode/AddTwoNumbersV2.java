import java.math.BigInteger;

/**
 * Created by abhijeet on 8/19/16.
 */
public class AddTwoNumbersV2 {
    public static void main(String[] args) {
        AddTwoNumbers.ListNode l1 = (new AddTwoNumbers.ListNode(2));
        l1.next = new AddTwoNumbers.ListNode(4);
        l1.next.next = new AddTwoNumbers.ListNode(3);

        AddTwoNumbers.ListNode l2 = (new AddTwoNumbers.ListNode(5));
        l2.next = new AddTwoNumbers.ListNode(6);
        l2.next.next = new AddTwoNumbers.ListNode(4);

        AddTwoNumbers.ListNode result = AddTwoNumbers.Solution.addTwoNumbers(l1, l2);
        while (result != null) {
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
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;

            StringBuffer sb1 = new StringBuffer();
            while (l1 != null) {
                sb1.append(l1.val);
                l1 = l1.next;
            }

            StringBuffer sb2 = new StringBuffer();
            while (l2 != null) {
                sb2.append(l2.val);
                l2 = l2.next;
            }

            BigInteger b1 = new BigInteger(sb1.toString());
            BigInteger b2 = new BigInteger(sb2.toString());

            BigInteger b = b1.add(b2);
            String s = b.toString(10);
            ListNode node = null;
            ListNode node1 = null;
            for (int i = 0; i < s.length(); i++) {
                if (node == null) {
                    node = new ListNode(s.charAt(i));
                    node1 = node;
                } else {
                    node.next = new ListNode(s.charAt(i));
                    node = node.next;
                }
            }
            return node1;
        }
    }
}
