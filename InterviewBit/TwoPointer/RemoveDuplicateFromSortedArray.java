package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhijeet on 6/26/2016.
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
 * <p>
 * Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array, remove the duplicates in place such that each element appear atmost twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 * <p>
 * For example,
 * Given input array A = [1,1,1,2,2],
 * <p>
 * Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] array = new Integer[] {1,};
        System.out.println("Len after compression: " + solution.removeDuplicates(new ArrayList<Integer>(Arrays.asList(array))));
    }

    public static class Solution {
        public int removeDuplicates(ArrayList<Integer> a) {
            int len = 0;
            if (a == null) {
                return len;
            }
            if (a.size() < 3) {
                return a.size();
            }

            int first = 0;
            int second = first + 1;

            while (second < a.size()) {
                while (second < a.size() && a.get(first) == a.get(second)) {
                    second++;
                }

                if (second - first >= 2) {
                    len += 2;
                } else {
                    len++;
                }
                first = second;
                second++;
            }

            if (first < a.size()) {
                if(second - first > 2) {
                    len += 2;
                } else {
                    len++;
                }
            }

            return len;
        }
    }

}
