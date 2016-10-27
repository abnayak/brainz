package BackTracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abhijeet on 10/25/2016.
 * https://www.interviewbit.com/courses/programming/topics/backtracking/
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * Example :
 * <p>
 * Given candidate set 10,1,2,7,6,1,5 and target 8,
 * <p>
 * A solution set is:
 * <p>
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class CombinationSumII {
    public static void main(String[] args) {
        Integer[] array = {10, 1, 2, 7, 6, 1, 5,1,1};
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i : array) {
            list.add(i);
        }
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.combinationSum(list, 2);
        for(ArrayList<Integer> i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
            Collections.sort(a);
            if(b == 0) return result;
            if(a == null || a.size() == 0) return result;
            findSolutions(a, 0, b, new ArrayList<>());
            return result;
        }

        private void findSolutions(ArrayList<Integer> a, int index, int b, ArrayList<Integer> partialSolution) {
            if (b == 0) {
                result.add(new ArrayList(partialSolution));
                return;
            }
            if (b < 0) return;
            if (index >= a.size()) return;

            partialSolution.add(a.get(index));
            findSolutions(a, index + 1, b - a.get(index), partialSolution);
            partialSolution.remove(partialSolution.size() - 1);
            while(index + 1< a.size() && a.get(index) == a.get(index+1)) index++;
            findSolutions(a, index + 1, b, partialSolution);
        }
    }
}
