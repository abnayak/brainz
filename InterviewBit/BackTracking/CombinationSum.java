package BackTracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abhijeet on 10/26/2016.
 */
public class CombinationSum {
    public static void main(String[] args) {
        Integer[] array = {2, 3, 6, 7};
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : array) {
            list.add(i);
        }
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.combinationSum(list, 7);
        for (ArrayList<Integer> i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
            Collections.sort(a);
            if (b == 0) return result;
            if (a == null || a.size() == 0) return result;
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
            findSolutions(a, index, b - a.get(index), partialSolution);
            partialSolution.remove(partialSolution.size() - 1);
            while (index + 1 < a.size() && a.get(index) == a.get(index + 1)) index++;
            findSolutions(a, index + 1, b, partialSolution);
        }
    }

}
