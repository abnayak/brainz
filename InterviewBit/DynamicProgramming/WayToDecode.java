package DynamicProgramming;

import java.util.Arrays;

public class WayToDecode {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.numDecodings("10"));
    }

    public static class Solution {
        int[] count;

        public int numDecodings(String A) {
            count = new int[A.length()];
            Arrays.fill(count, -1);
            return helper(A, 0);
        }

        public int helper(String A, int index) {
            if (index == A.length()) {
                return 1;
            }

            if (A.charAt(index) == '0') {
                return 0;
            }

            if (count[index] != -1) {
                return count[index];
            }

            int n = 0;
            int m = 0;

            n = helper(A, index + 1);

            if (index + 1 < A.length()) {
                String str = A.substring(index, index + 2);
                int number = Integer.parseInt(str);
                if (number >= 1 && number <= 26) {
                    m = helper(A, index + 2);
                }
            }

            count[index] = n + m;
            return n + m;
        }
    }
}
