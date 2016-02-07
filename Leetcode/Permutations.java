/**
 * https://leetcode.com/problems/permutations/
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * More information about the solution:
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ
 */

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static class Solution {
        private List<List<Integer>> permutations;
        private List<Pair> numberFrequency;

        private static class Pair {
            public Pair(Integer value, Integer count) {
                this.value = value;
                this.count = count;
            }

            public Integer value;
            public Integer count;
        }

        public List<List<Integer>> permute(int[] nums) {
            permutations = new ArrayList<>();
            numberFrequency = new ArrayList<>();
            int[] result = new int[nums.length];

            // Generate the number frequency array
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    numberFrequency.get(numberFrequency.size() - 1).count++;
                } else {
                    numberFrequency.add(new Pair(nums[i], 1));
                }
            }
            permuteHelper(numberFrequency, result, 0);
            return permutations;
        }

        private void permuteHelper(List<Pair> numberFrequency, int[] result, int index) {
            if (index == result.length) {
                List<Integer> newSolution = new ArrayList<>();
                for (int i : result) {
                    newSolution.add(i);
                }
                permutations.add(newSolution);
            }
            for(int i = 0; i < numberFrequency.size(); i++) {
                if(numberFrequency.get(i).count != 0) {
                    result[index] = numberFrequency.get(i).value;
                    numberFrequency.get(i).count--;
                    permuteHelper(numberFrequency, result, index + 1);
                    numberFrequency.get(i).count++;
                }
            }

        }
    }


    public static void main (String[] args) {
        int[] numbers = {1,2,2,3,3};
        Solution solution = new Solution();
        List<List<Integer>> permutations = solution.permute(numbers);

        for (int i = 0; i < permutations.size(); i++) {
            for (int j = 0; j < permutations.get(i).size(); j++) {
                System.out.print(permutations.get(i).get(j));
            }
            System.out.println("");
        }
    }
}
