package Array;

import java.util.ArrayList;

/**
 * Created by abhijeet on 9/29/16.
 * https://www.interviewbit.com/problems/numrange/
 * Given an array of non negative integers A, and a range (B, C),
 * find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C
 * <p>
 * Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 * where 0 <= i <= j < size(A)
 * <p>
 * Example :
 * <p>
 * A : [10, 5, 1, 0, 2]
 * (B, C) : (6, 8)
 * ans = 3
 * as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]
 */
public class Numrange {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {10, 5, 1, 0, 2};
        for(int i : array) {
            list.add(i);
        }

        Solution solution = new Solution();
        System.out.println(solution.numRangeBruteForce(list, 6, 8));
    }

    public static class Solution {
        public int numRangeBruteForce(ArrayList<Integer> a, int b, int c) {
            int count = 0;
            for (int i = 0; i < a.size(); i++) {
                int sum = 0;
                for (int j = i; j < a.size(); j++) {
                    sum += a.get(j);
                    if (sum >= b && sum <= c) count++;
                    if(sum > c ) break;
                }
            }
            return count;
        }
    }

}
