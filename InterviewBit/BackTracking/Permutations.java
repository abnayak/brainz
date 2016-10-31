package BackTracking;

import java.util.*;

/**
 * Created by abhijeet on 10/30/2016.
 * https://www.interviewbit.com/problems/permutations/
 */
public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        ArrayList<ArrayList<Integer>> result = solution.permute(list);
        for (ArrayList<Integer> i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
            if (a == null) return result;
            Collections.sort(a);
            result.add(new ArrayList(a));

            while (true) {
                int nextSmallerElementToSwap = nextSmallerElement(a);
                if (nextSmallerElementToSwap == -1) break;
                int nextBiggerElementToSwap = findNextElementPosition(a, nextSmallerElementToSwap);
                Collections.swap(a, nextSmallerElementToSwap, nextBiggerElementToSwap);
                int begin = nextSmallerElementToSwap + 1;
                int end = a.size() -1;
                while ( begin < end) {
                    Collections.swap(a, begin, end);
                    begin++;
                    end--;
                }
                result.add(new ArrayList<>(a));
            }

            return result;
        }

        private int nextSmallerElement(ArrayList<Integer> a) {
            int pos = -1;
            for (int i = 1; i < a.size(); i++) {
                if (a.get(i - 1) < a.get(i)) {
                    pos = i - 1;
                }
            }
            return pos;
        }

        private int findNextElementPosition(ArrayList<Integer> a, int position) {
            int pos = position;
            for (int i = position + 1; i < a.size(); i++) {
                if (a.get(i) > a.get(position)) pos = i;
            }
            return pos;
        }
    }
}
