import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 9/13/16.
 */
public class NQueenProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> result = solution.solveNQueens(4);
        for (List<String> strs : result) {
            for (String s : strs) {
                System.out.println(s);
            }

            System.out.println("\n");
        }
    }

    public class Solution {
        List<List<String>> solution = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            // initialize the board
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }

            solve(board, n, 0);

            return solution;
        }

        private void solve(char[][] board, final int n, int row) {
            if (row >= n) {
                List<String> rows = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    rows.add(new String(board[i]));
                }
                solution.add(rows);
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
