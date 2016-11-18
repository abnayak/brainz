package Hashing;

import java.util.List;

/**
 * Created by abhijeet on 11/16/16.
 */
public class ValidSudoku {
    public static void main(String[] args) {

    }

    public static class Solution {
        private static final int GRID = 9;

        public int isValidSudoku(final List<String> a) {
            char[][] board = new char[GRID][GRID];
            for (int i = 0; i < GRID; i++) {
                String s = a.get(i);
                for (int j = 0; j < GRID; j++) {
                    board[i][j] = s.charAt(j);
                }
            }
            return isValidSudoku(board);
        }

        public int isValidSudoku(char[][] board) {
            boolean check;
            for (int i = 0; i < GRID; i++) {
                for (int j = 0; j < GRID; j++) {
                    check = checkColumn(board, j) && checkRow(board, i) && checkBox(board, i, j);
                    if (!check) return 0;
                }
            }
            return 1;
        }

        private boolean checkColumn(char[][] board, int column) {
            int[] hash = new int[10];
            for (int i = 0; i < GRID; i++) {
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
            for (int i = 0; i < GRID; i++) {
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
