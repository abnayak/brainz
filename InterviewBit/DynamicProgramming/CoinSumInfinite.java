package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abhijeet on 12/13/16.
 * https://www.interviewbit.com/problems/coin-sum-infinite/
 */
public class CoinSumInfinite {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8};
        for (int i : array) {
            list.add(i);
        }
        Solution solution = new Solution();
        System.out.println(solution.coinchange2(list, 458));
    }

    public static class Solution {
        private int[] buffer;

        public int coinchange2(ArrayList<Integer> a, int b) {
            Collections.sort(a);
            buffer = new int[b + 1];
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) <= b) {
                    buffer[a.get(i)] = 1;
                }
            }

            for (int i = 1; i <= b; i++) {
                for (int j = 0; j < a.size(); j++) {
                    int previousIndex = i - a.get(j);
                    if (previousIndex >= 1) {
                        if (buffer[previousIndex] > 0) {
                            buffer[i] += buffer[previousIndex];
                        }
                    }
                }
            }
            return buffer[b];
        }
    }
}
