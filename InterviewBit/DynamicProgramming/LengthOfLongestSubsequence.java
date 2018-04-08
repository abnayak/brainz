package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequence {
    public static void main(String[] args) {
        Integer[] input = {1, 11, 2, 10, 4, 5, 2, 1};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(input));

        Solution solution = new Solution();
        System.out.println(solution.longestSubsequenceLength(list));

    }

    public static class Solution {
        // DO NOT MODIFY THE LIST. IT IS READ ONLY
        public int longestSubsequenceLength(final List<Integer> A) {
            if (A.size() == 0 || A.size() == 1) {
                return A.size();
            }

            int[] increasingSubsequence = getIncreasingSubsequence(A);
            int[] decreasingSubsequence = getDecreasingSubsequence(A);

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < A.size(); i++) {
                if (increasingSubsequence[i] + decreasingSubsequence[i] - 1 > max) {
                    max = increasingSubsequence[i] + decreasingSubsequence[i] - 1;
                }
            }

            return max;
        }

        private int[] getIncreasingSubsequence(List<Integer> A) {
            // maxSubsequenceLength[i] == maximum length of increasing subsequence at i (including i)
            int[] increasingSubsequenceLength = new int[A.size()];
            for (int i = 0; i < A.size(); i++) {
                increasingSubsequenceLength[i] = 1;
            }

            for (int i = 1; i < A.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (A.get(j) < A.get(i)
                            && increasingSubsequenceLength[i] < increasingSubsequenceLength[j] + 1) {
                        increasingSubsequenceLength[i] = increasingSubsequenceLength[j] + 1;
                    }
                }
            }
            return increasingSubsequenceLength;
        }

        /**
         * Get the array containing the max length of decreasing subsequence
         *
         * @param A
         * @return
         */
        private int[] getDecreasingSubsequence(List<Integer> A) {
            int[] decreasingSubsequenceLength = new int[A.size()];
            for (int i = 0; i < A.size(); i++) {
                decreasingSubsequenceLength[i] = 1;
            }

            for (int i = A.size() - 2; i >= 0; i--) {
                for (int j = A.size() - 1; j > i; j--) {
                    if (A.get(i) > A.get(j)
                            && decreasingSubsequenceLength[i] < decreasingSubsequenceLength[j] + 1) {
                        decreasingSubsequenceLength[i] = decreasingSubsequenceLength[j] + 1;
                    }
                }
            }

            return decreasingSubsequenceLength;
        }
    }
}
