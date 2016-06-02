import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by abhijeet on 5/30/2016.
 */
public class TopKFrequestElements {
    public static void main (String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{1,1,1,2,2,3};
        int k = 2;
        List<Integer> soluton = solution.topKFrequent(input, k);

        // Print the solution
        for(Integer integer : soluton) {
            System.out.printf("%d ", integer);
        }
    }

    public static class Solution {
        public List<Integer> topKFrequent (int[] nums, int k) {
            List<Integer> solution = new ArrayList<>();

            Map<Integer, Integer> countMap = new HashMap<>();

            // Generate the count map
            for (int i : nums) {
                if (countMap.containsKey(i)) {
                    countMap.put(i, countMap.get(i) + 1);
                } else {
                    countMap.put(i, 1);
                }
            }

            // Create a priority queue of size k and ordering of elements is determined by the count
            PriorityQueue<Map.Entry<Integer, Integer>> minHeapBasedOnCount = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare (final Map.Entry<Integer, Integer> first, final Map.Entry<Integer, Integer> second) {
                    return first.getValue() - second.getValue();
                }
            });

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (minHeapBasedOnCount.size() == k) {
                    if (entry.getValue() > minHeapBasedOnCount.peek().getValue()) {
                        minHeapBasedOnCount.poll();
                        minHeapBasedOnCount.offer(entry);
                    }
                } else {
                    minHeapBasedOnCount.offer(entry);
                }
            }


            while (minHeapBasedOnCount.size() != 0) {
                solution.add(minHeapBasedOnCount.poll().getKey());
            }

            // Reverse the solution because we added the smallest to largest elements
            Collections.reverse(solution);

            return solution;
        }
    }
}
