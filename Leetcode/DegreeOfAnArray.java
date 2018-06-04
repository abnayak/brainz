import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(nums));
    }

    private static class Solution {
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> count = new HashMap<>();
            Map<Integer, Integer> firstEncountered = new HashMap<>();
            Map<Integer, Integer> lastEncountered = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int key = nums[i];
                if (count.putIfAbsent(key, 1) == null) {
                    firstEncountered.put(key, i);
                    lastEncountered.put(key, i);
                } else {
                    count.put(key, count.get(key) + 1);
                    lastEncountered.put(key, i);
                }
            }

            Integer degreeOfNumsArray = Collections.max(count.values());
            int minimumSubArrayLengthWithSameDegree = Integer.MAX_VALUE;

            for (Integer key : count.keySet()) {
                if (count.get(key) == degreeOfNumsArray) {
                    int subArrayLen = (lastEncountered.get(key) - firstEncountered.get(key)) + 1;
                    minimumSubArrayLengthWithSameDegree = Math.min(minimumSubArrayLengthWithSameDegree, subArrayLen);
                }
            }

            return minimumSubArrayLengthWithSameDegree;
        }
    }


}
