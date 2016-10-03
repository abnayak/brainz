package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by abhijeet on 10/1/16.
 */
public class SortLinkedList {
    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);

        three.next = one;
        one.next = two;
        two.next = four;

        Solution solution = new Solution();
        ListNode result = solution.sortList(three);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static class Solution {

        public ListNode sortList(ListNode a) {
            if(a == null) return null;
            return mergeSort(a);
        }

        private ListNode mergeSort(ListNode head) {
            // we have only element in the list, just return it.
            if (head.next == null) return head;

            int len = count(head);
            int mid = len / 2;
            ListNode firstPart = head;
            ListNode secondPart = head;

            while (--mid != 0) {
                secondPart = secondPart.next;
            }
            // split the two
            ListNode temp = secondPart;
            secondPart = secondPart.next;
            temp.next = null;

            firstPart = mergeSort(firstPart);
            secondPart = mergeSort(secondPart);

            return mergeTwoLists(firstPart, secondPart);
        }

        private class MyComparator implements Comparator<ListNode> {
            @Override
            public int compare(ListNode a, ListNode b) {
                return b.val - a.val;
            }
        }

        private ListNode mergeTwoLists(ListNode a, ListNode b) {
            PriorityQueue<ListNode> maxHeap = new PriorityQueue(new MyComparator());
            while (a != null) {
                maxHeap.offer(a);
                a = a.next;
            }
            while (b != null) {
                maxHeap.offer(b);
                b = b.next;
            }

            while (!maxHeap.isEmpty()) {
                if (a == null) {
                    a = maxHeap.poll();
                    a.next = null;
                } else {
                    maxHeap.peek().next = a;
                    a = maxHeap.poll();
                }
            }
            return a;
        }

        private int count(ListNode head) {
            if (head == null) return 0;
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }
            return count;
        }
    }
}
