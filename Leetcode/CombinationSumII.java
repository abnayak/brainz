import java.util.*;

/**
 * Created by abhijeet on 9/9/16.
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        Solution solution = new Solution();
        List<List<Integer>> results = solution.combinationSum2(candidates, 8);
        for (List<Integer> result : results) {
            for (Integer i : result) {
                System.out.printf("%d ", i);
            }
            System.out.println("");
        }
    }

    public static class Solution {
        List<List<Integer>> solution = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            findSolution(candidates, target, 0, new LinkedList<>());
            return solution;
        }

        private void findSolution(int[] candidate, int target, int index, List<Integer> list) {
            if (target == 0) {
                String str = list.toString();
                if (!set.contains(str)) {
                    set.add(str);
                    solution.add(new ArrayList(list));
                }
                return;
            }
            if (target < 0 || index >= candidate.length) return;

            // Take the current element
            if (index < candidate.length) {
                list.add(candidate[index]);
                findSolution(candidate, target - candidate[index], index + 1, list);
            }

            // Do not take the current element
            list.remove(list.size() - 1);
            findSolution(candidate, target, index + 1, list);
        }
    }
}