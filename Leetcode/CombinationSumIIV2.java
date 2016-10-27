import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhijeet on 9/10/16.
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumIIV2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5,1,};
        Solution solution = new Solution();
        List<List<Integer>> results = solution.combinationSum2(candidates, 2);
        for (List<Integer> result : results) {
            for (Integer i : result) {
                System.out.printf("%d ", i);
            }
            System.out.println("");
        }
    }

    public static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> result = new LinkedList<>();
            solveByBackTrack(results, result, candidates, target, 0);
            return results;
        }

        public void solveByBackTrack(List<List<Integer>> results, List<Integer> result, int[] candidate, int target, int start) {
            if (target == 0) {
                results.add(new ArrayList(result));
            }
            if (target < 0 || start >= candidate.length) return;

            for (int i = start; i < candidate.length; i++) {
                if (i > start && candidate[i] == candidate[i - 1]) continue;
                result.add(candidate[i]);
                solveByBackTrack(results, result, candidate, target - candidate[i], i + 1);
                result.remove(result.size()-1);
            }
        }
    }
}
