package TwoPointer;

import java.util.ArrayList;

/**
 * Created by abhijeet on 10/6/16.
 * https://www.interviewbit.com/problems/max-continuous-series-of-1s/#_=_
 * <p>
 * You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
 * Find the position of zeros which when flipped will produce maximum continuous series of 1s.
 * <p>
 * For this problem, return the indices of maximum continuous series of 1s in order.
 * <p>
 * Example:
 * <p>
 * Input :
 * Array = {1 1 0 1 1 0 0 1 1 1 }
 * M = 1
 * <p>
 * Output :
 * [0, 1, 2, 3, 4]
 * <p>
 * If there are multiple possible solutions, return the sequence which has the minimum start index.
 */
public class MaxContinuousSeriesOfOnes {
    public static void main(String[] args) {

    }
    // This solution does not work.
    public class Solution {
        public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
            int i = 0;
            int j = 0;
            int len = Integer.MIN_VALUE;
            int flipsLeft = b;
            int solutionIndex = 0;
            while (j < a.size()) {
                if (a.get(j) == 1) {
                    j++;
                } else if (a.get(j) == 0 && flipsLeft > 0) {
                    j++;
                    flipsLeft--;
                } else {
                    if (j - i + 1 > len) {
                        solutionIndex = i;
                        len = j - i + 1;
                    }
                    while (i < j && a.get(i) != 0) i++;
                    i++;
                    flipsLeft++;

                }
            }
            return null;
        }
    }

}
