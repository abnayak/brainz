/**
 * Created by abhijeet on 9/9/16.
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidateSudoku {

    public class Solution {
        private static final int ROWS = 9;

        public boolean isValidSudoku(char[][] board) {
            boolean check;
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < ROWS; j++) {
                    check = checkColumn(board, j) && checkRow(board, i) && checkBox(board, i, j);
                    if (!check) return false;
                }
            }
            return true;
        }

        private boolean checkColumn(char[][] board, int column) {
            int[] hash = new int[10];
            for (int i = 0; i < ROWS; i++) {
                if (board[i][column] != '.') {
                    int value = board[i][column] - '0';
                    if (hash[value] == 1) return false;
                    else hash[value] = 1;
                }
            }
            return true;
        }

        private boolean checkRow(char[][] board, int row) {
            int[] hash = new int[10];
            for (int i = 0; i < ROWS; i++) {
                if (board[row][i] != '.') {
                    int value = board[row][i] - '0';
                    if (hash[value] == 1) return false;
                    else hash[value] = 1;
                }
            }
            return true;
        }

        private boolean checkBox(char[][] board, int row, int column) {
            int[] hash = new int[10];
            int boxStartRow = row - row % 3;
            int boxStartCol = column - column % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i + boxStartRow][j + boxStartCol] != '.') {
                        int value = board[i + boxStartRow][j + boxStartCol] - '0';
                        if (hash[value] == 1) return false;
                        else hash[value] = 1;
                    }
                }
            }
            return true;
        }
    }
}
