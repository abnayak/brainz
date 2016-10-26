package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhijeet on 6/26/2016.
 * https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
 *
 Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
 TIP: C users, please malloc the result into a new array and return the result.
 If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

 Example :

 Input :
 A : [1 5 8]
 B : [6 9]

 Modified A : [1 5 6 8 9]

 */
public class MergeTwoSortedListII {
    public static void main(String[] args) {
        Integer[] array1 = new Integer[] {3,4,5,6,7,13};
        Integer[] array2 = new Integer[] {1,2,14};

        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(array1));
        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(array2));
        Solution solution = new Solution();

        solution.merge(arrayList1, arrayList2);

        for(Integer i : arrayList1) {
            System.out.printf("%d, ", i);
        }
    }

    public static class Solution {
        public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
            if(a == null || a.size() ==0) {
                return;
            }

            if(b == null || b.size() == 0) {
                return;
            }

            int ai =0;
            int bi = 0;
            while (bi < b.size() && ai < a.size()) {
                if(b.get(bi) <= a.get(ai)) {
                    a.add(ai, b.get(bi));
                    ai++;
                    bi++;
                } else if(a.get(ai) < b.get(bi)) {
                    ai++;
                }
            }

            while(bi < b.size()) {
                a.add(ai++, b.get(bi++));
            }
        }
    }

}
