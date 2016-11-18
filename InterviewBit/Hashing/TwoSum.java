package Hashing;

import BitManipulation.NumberOneBits;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by abhijeet on 11/15/16.
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2.
 * Please note that your returned answers (both index1 and index2 ) are not zero-based.
 * Put both these numbers in order in an array and return the array from your function ( Looking at the function signature
 * will make things clearer ). Note that, if no pair exists, return empty list.
 * <p>
 * If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum
 * index2, choose the one with minimum index1 out of them.
 * <p>
 * Input: [2, 7, 11, 15], target=9
 * Output: index1 = 1, index2 = 2
 * <p>
 * https://www.interviewbit.com/problems/2-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = {2,11,3, 6, 15,7};
        List<Integer> list = new ArrayList<>();
        for(int i : array) {
            list.add(i);
        }
        Solution solution = new Solution();
        List<Integer> result = solution.twoSum(list, 9);
        System.out.println(result.get(0) + " " + result.get(1));
    }

    public static class Solution {
        public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
            ArrayList<Integer> list = new ArrayList<>();
            if (a == null || a.size() == 0) return list;
            Hashtable<Integer, Integer> table = new Hashtable<>();

            for (int i = 0; i < a.size(); i++) {
                int requiredValue = b - a.get(i);
                if(table.containsKey(requiredValue)) {
                    list.add(table.get(requiredValue) + 1);
                    list.add(i + 1);
                    return list;
                } else {
                    if(!table.containsKey(a.get(i)))
                        table.put(a.get(i), i);
                }
            }

            return list;
        }
    }
}
