package DynamicProgramming;

import java.util.Arrays;

public class Stairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }

    public static class Solution {
        int total = 0;
        int[] stepCount;

        public int climbStairs(int A) {
            stepCount = new int[A + 1];
            Arrays.fill(stepCount, -1);
            climbStairsHelper(A);
            return stepCount[A];
        }

        public int climbStairsHelper(int A) {
            if (stepCount[A] != -1) {
                return stepCount[A];
            }

            if (A == 0) {
                return 1;
            }

            int oneStepsUp;
            int twoStepsUp = 0;

            oneStepsUp = climbStairsHelper(A - 1);
            if (A >= 2) {
                twoStepsUp = climbStairsHelper(A - 2);
            }

            stepCount[A] = oneStepsUp + twoStepsUp;
            return stepCount[A];
        }
    }
}
