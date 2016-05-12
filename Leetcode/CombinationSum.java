/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
*/

import java.util.*;
import java.util.LinkedList;

public class CombinationSum {
    public static void main(String[] args) {
        int[] array = {2,3,6,7};
        Solution soluton = new Solution();
        List<List<Integer>> result  = soluton.combinationSum(array, 7);

        for(List<Integer> i: result) {
            for(int j: i) {
                System.out.print(j + " ");
            }
            System.out.println("\n");
        }

    }

    public static class Solution {
        List<List<Integer>> solution;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            solution = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, target, 0, new LinkedList<>());
            return solution;
        }

        public void helper(int[] candidates, int target, int index, LinkedList<Integer> list) {
            if (index >= candidates.length){
                return;
            }
            if (target == 0) {
                solution.add(list);
                return ;
            }

            if( target >= candidates[index]) {
                LinkedList<Integer> newList = (LinkedList)list.clone();
                LinkedList<Integer> anotherList = (LinkedList)list.clone();

                newList.add(candidates[index]);
                anotherList.add(candidates[index]);

                helper(candidates, target-candidates[index], index, newList );

                helper(candidates, target, index+1, list);
            }
        }
    }
}
