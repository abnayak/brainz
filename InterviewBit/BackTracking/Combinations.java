package BackTracking;

import java.util.ArrayList;

/**
 * Created by abhijeet on 10/26/2016
 * https://www.interviewbit.com/problems/combinations/
 */
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.combine(4, 2);
        for(ArrayList<Integer> i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> combine(int n, int k) {
            findSolution(new ArrayList<>(), n, k, 1);
            return result;
        }

        public void findSolution(ArrayList<Integer> partialSolution, int n, int k, int index) {
            if (partialSolution.size() == k) {
                result.add(new ArrayList(partialSolution));
                return;
            }
            if (index > n) return;

            for (int i = index; i <= n; i++) {
                partialSolution.add(i);
                findSolution(partialSolution, n, k, i + 1);
                partialSolution.remove(partialSolution.size() - 1);
            }
        }
    }
}
