/**
 * Created by abhijeet on 9/16/16.
 * https://leetcode.com/problems/n-queens-ii/
 */
public class NQueenII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));
    }

    public static class Solution {
        int count = 0;
        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            // initialize the board
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }

            solve(board, n, 0);

            return count;
        }

        private void solve(char[][] board, final int n, int row) {
            if (row >= n) {
                count++;
                return;
            }

            for (int i = 0; i < n; i++) {
                board[row][i] = 'Q';
                if (isValid(board, n, row, i)) solve(board, n, row + 1);
                board[row][i] = '.';
            }
        }

        private boolean isValid(char[][] board, int n, int x, int y) {
            return safeOnDiagonal(board, n, x, y) && safeOnHorizontal(board, n, x, y) && safeOnVertical(board, n, x, y);
        }

        private boolean safeOnHorizontal(char[][] board, int n, int x, int y) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (board[x][i] == 'Q') count++;
            }
            if (count > 1) return false;
            return true;
        }

        private boolean safeOnVertical(char[][] board, int n, int x, int y) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (board[i][y] == 'Q') count++;
            }
            if (count > 1) return false;
            return true;
        }

        private boolean safeOnDiagonal(char[][] board, int n, int x, int y) {
            int count = 0;
            for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') count++;
            }
            if (count > 1) return false;

            count = 0;
            for (int i = x, j = y; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 'Q') count++;
            }
            if (count > 1) return false;

            return true;
        }
    }
}
