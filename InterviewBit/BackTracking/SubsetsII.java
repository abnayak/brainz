package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by abhijeet on 10/26/2016.
 */
public class SubsetsII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> result = solution.subsetsWithDup(list);
        for (ArrayList<Integer> i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
            if (a == null) return result;

            Collections.sort(a);
            findSolution(a, new ArrayList<Integer>(), 0);

            // Sort the result before print it
            Collections.sort(result, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> a, List<Integer> b) {
                    int size = Math.min(a.size(), b.size());
                    for (int i = 0; i < size; i++) {
                        int cmp = Integer.compare(a.get(i), b.get(i));
                        if (cmp != 0)
                            return cmp;
                    }
                    return Integer.compare(a.size(), b.size());
                }
            });

            return result;
        }

        private void findSolution(ArrayList<Integer> a, ArrayList<Integer> partialSolution, int index) {
            if (index >= a.size()) {
                result.add(new ArrayList(partialSolution));
                return;
            }

            partialSolution.add(a.get(index));
            findSolution(a, partialSolution, index + 1);
            partialSolution.remove(partialSolution.size() - 1);
            // Skip similar elements
            while(index + 1 < a.size() && a.get(index) == a.get(index + 1)) index++;
            findSolution(a, partialSolution, index + 1);
        }
    }
}
