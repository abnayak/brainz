package BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by abhijeet on 10/30/2016.
 * https://www.interviewbit.com/problems/subset/
 */
public class Subset {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> result = solution.subsets(list);
        for (ArrayList<Integer> i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
            if(a == null) return result;
            Collections.sort(a);
            findSolution(new ArrayList<>(), a, 0);

            // sort the result
            Collections.sort(result, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    int len = Math.min(o1.size(), o2.size());
                    for (int i = 0; i < len; i++) {
                        int compare = Integer.compare(o1.get(i), o2.get(i));
                        if(compare != 0) return compare;
                    }
                    return Integer.compare(o1.size(), o2.size());
                }
            });
            return result;
        }

        private void findSolution(List<Integer> partialSolution, ArrayList<Integer> input, int index) {
            if (index >= input.size()) {
                result.add(new ArrayList(partialSolution));
                return;
            }

            partialSolution.add(input.get(index));
            findSolution(partialSolution, input, index + 1);
            partialSolution.remove(partialSolution.size() - 1);
            findSolution(partialSolution, input, index + 1);
        }
    }
}

