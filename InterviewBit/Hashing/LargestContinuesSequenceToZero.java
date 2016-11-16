package Hashing;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by abhijeet on 11/9/16.
 * https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
 * Find the largest continuous sequence in a array which sums to zero.

 Example:


 Input:  {1 ,2 ,-2 ,4 ,-4}
 Output: {2 ,-2 ,4 ,-4}

 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */
public class LargestContinuesSequenceToZero {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {1, 3, 0, -2, 2};
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        Solution solution = new Solution();
        ArrayList<Integer> result = solution.lszero(list);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        public ArrayList<Integer> lszero(ArrayList<Integer> a) {
            Hashtable<Integer, Integer> hashTable = new Hashtable<>();
            int sum = 0;
            int begin = -1;
            int end = -1;
            for (int i = 0; i < a.size(); i++) {
                sum += a.get(i);
                if (sum == 0) {
                    begin = 0;
                    end = i;
                } else if (hashTable.containsKey(sum) && hashTable.get(sum) + 1 != i) {
                    if (i - (hashTable.get(sum) + 1) > end - begin) {
                        begin = hashTable.get(sum) + 1;
                        end = i;
                    }
                } else if (a.get(i) == 0) {
                    if (begin == -1 && end == -1) {
                        begin = i;
                        end = i;
                    }
                }

                if (!hashTable.containsKey(sum)) hashTable.put(sum, i);
            }

            if (begin == -1 && end == -1) return new ArrayList<>();

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = begin; i <= end; i++) {
                result.add(a.get(i));
            }
            return result;
        }
    }
}
