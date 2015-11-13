/*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    For example,
    If n = 4 and k = 2, a solution is:
*/

import java.util.*;

public class Combinations {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result  = solution.combine(4,2);
        for(List<Integer> i: result) {
            for(int j: i) {
                System.out.print(j + " ");
            }
            System.out.println("\n");
        }
    }

    public static class Solution {
        List<List<Integer>> solution = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> temp = new ArrayList<>();

            findSol(n, k, 1, 0, temp);
            return solution;
        }

        public void findSol(final int n, int k, final int startIndex, int currentLevel, List<Integer> tempSolution) {

            if(currentLevel == k) {
                solution.add(new ArrayList(tempSolution));
                return;
            }


            for(int i = startIndex; i <= n; i++) {
                tempSolution.add(i);
                findSol(n, k, i+1, currentLevel+1, tempSolution);
                tempSolution.remove(tempSolution.size()-1);
            }
        }
    }
}
