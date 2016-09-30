package Array;

import java.util.*;

/**
 * Created by abhijeet on 9/29/16.
 * https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
 */
public class KthSmallestElement {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] array = {2, 1, 4, 3, 2};
        for(int i : array) list.add(i);

        Solution solution = new Solution();
        System.out.println(solution.kthsmallest(list, 3));
    }

    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int kthsmallest(final List<Integer> a, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.<Integer>reverseOrder());
            for(Integer i : a) {
                if( minHeap.size() < k) {
                    minHeap.offer(i);
                } else {
                    if (i < minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(i);
                    }
                }
            }
            return minHeap.poll();
        }
    }

}
