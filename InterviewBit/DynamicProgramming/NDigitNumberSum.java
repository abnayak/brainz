package DynamicProgramming;

public class NDigitNumberSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solve(2, 4));
    }

    public static class Solution {
        int[][] table;

        public int solve(int A, int B) {
            table = new int[A + 1][B + 1];
            for (int i = 0; i <= A; i++) {
                for (int j = 0; j <= B; j++) {
                    table[i][j] = -1;
                }
            }

            int count = 0;
            for (int i = 1; i <= 9; i++) {
                if (B - i >= 0) {
                    count += helper(A - 1, B - i);
                }
            }
            return count;
        }

        public int helper(int n, int sum) {
            if (n == 0) {
                return sum == 0 ? 1 : 0;
            }

            if (table[n][sum] != -1) {
                return table[n][sum];
            }

            int count = 0;
            for (int i = 0; i <= 9; i++) {
                if (sum - i >= 0) {
                    count += helper(n - 1, sum - i);
                }
            }
            table[n][sum] = count;
            return count;
        }
    }
}
