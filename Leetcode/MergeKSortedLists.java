/*
* Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/


import java.util.ArrayList;

public class MergeKSortedLists {
    public static void main(String[] args) {

    }
    public static class Solution {
        ArrayList<ListNode> newLists = new ArrayList<>();

        public ListNode mergeKLists(ListNode[] lists) {
            for(ListNode i : lists) {
                newLists.add(i);
            }
            ListNode temp = null;
            ListNode solution = null;
            ListNode end = null;
            while( (temp = getNode(newLists)) != null) {
                if (solution == null) {
                    solution = temp;
                    end = temp;
                } else {
                    end.next = temp;
                    end = temp;
                }
            }
            return solution;
        }
        private static ListNode getNode(ArrayList<ListNode> lists) {
            if (lists.size() == 0) {
                return null;
            }
            int minElementIndex = 0;
            for(int i = 0; i < lists.size(); i++) {
                if (lists.get(i).val < lists.get(minElementIndex).val) {
                    minElementIndex = i;
                }
            }

            ListNode temp = null;
            if(lists.get(minElementIndex).next == null) {
                temp = lists.get(minElementIndex);
                lists.remove(minElementIndex);
            } else {
                temp = new ListNode(lists.get(minElementIndex).val);
                temp.next = null;
                lists.get(minElementIndex).val = lists.get(minElementIndex).next.val;
                lists.get(minElementIndex).next = lists.get(minElementIndex).next;
            }
            return temp;
        }
    }

    private static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}
