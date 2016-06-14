import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by abhijeet on 6/12/2016.
 * https://www.interviewbit.com/problems/intersection-of-sorted-arrays/
 */

public class IntersectionOfTwoArrays {
    public static void main (String[] args) {
        Solution solution = new Solution();
        Integer[] array1 = new Integer[] {1, 2, 3, 3, 4, 5, 6};
        Integer[] array2 = new Integer[5];

        List<Integer> result = solution.intersect(Arrays.asList(array1), Arrays.asList(array2));
        for(int i : result) {
            System.out.printf("%d, ",i );
        }
    }

    public static class Solution {
        // DO NOT MODIFY THE LISTS
        public ArrayList<Integer> intersect (final List<Integer> a, final List<Integer> b) {
            ArrayList<Integer> solution = new ArrayList<>();

            int bsize = b.size();

            if (a == null || b == null || a.size() == 0 || b.size() == 0) {
                return solution;
            }

            LinkedHashMap<Integer, Integer> elementsInA = new LinkedHashMap<>();

            for (int i : a) {
                if( elementsInA.containsKey(i)) {
                    elementsInA.put(i, elementsInA.get(i) +1);
                } else {
                    elementsInA.put(i, 1);
                }
            }

            for (int i : b) {
                if( elementsInA.containsKey(i)) {
                    solution.add(i);
                    if(elementsInA.get(i) == 1) {
                        elementsInA.remove(i);
                    } else {
                        elementsInA.put(i, elementsInA.get(i)-1);
                    }
                }
            }
            return solution;
        }
    }

}
