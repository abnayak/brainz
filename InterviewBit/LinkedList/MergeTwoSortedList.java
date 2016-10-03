package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by abhijeet on 9/30/16.
 */
public class MergeTwoSortedList {
    public class Solution {
        private class MyComparator implements Comparator<ListNode> {
            @Override
            public int compare(ListNode a, ListNode b) {
                return b.val - a.val;
            }
        }
        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            PriorityQueue<ListNode> maxHeap = new PriorityQueue(new MyComparator());
            while(a != null) {
                maxHeap.offer(a);
                a = a.next;
            }
            while(b != null) {
                maxHeap.offer(b);
                b = b.next;
            }

            while(!maxHeap.isEmpty()) {
                if(a == null) {
                    a = maxHeap.poll();
                    a.next = null;
                } else {
                    maxHeap.peek().next = a;
                    a = maxHeap.poll();
                }
            }
            return a;
        }
    }

}
