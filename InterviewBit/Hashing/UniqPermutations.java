package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by abhijeet on 12/11/16.
 * https://www.interviewbit.com/problems/all-unique-permutations/
 */
public class UniqPermutations {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {1, 1, 2, 3};
        for (int i : array) {
            list.add(i);
        }
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.permute(list);
        for (ArrayList<Integer> temp : result) {
            for (int i : temp) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
            Collections.sort(a);
            findSolution(a, 0);
            for(ArrayList<Integer> l : set) {
                solution.add(l);
            }
            return solution;
        }

        private void findSolution(ArrayList<Integer> array, int index) {
            if (index >= array.size()) {
                set.add(new ArrayList<>(array));
            }
            for (int i = index; i < array.size(); i++) {
                if (i > index && array.get(i) == array.get(i - 1)) continue;

                Collections.swap(array, index, i);
                findSolution(array, index + 1);
                Collections.swap(array, index, i);
            }
        }
    }
}
