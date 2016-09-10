/**
 * Created by abhijeet on 9/8/16.
 * https://leetcode.com/problems/sudoku-solver/
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the character '.'.
 * <p>
 * You may assume that there will be only one unique solution.
 */
public class SudokuSolver {
    public static void main(String[] args) {

        String[] strings = {"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."};
        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {
            String str = strings[i];
            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        Solution solution = new Solution();
        solution.solveSudoku(board);

        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static class Solution {
        private static final int COLS = 9;
        private static final int ROWS = 9;

        public void solveSudoku(char[][] board) {
            solve(board);
        }

        private boolean solve(char[][] board) {
            // Search for a unsolved location
            int[] unsolvedLocation = SearchForUnsolvedLocation(board);

            // If no empty location found then end the recursion.
            if (unsolvedLocation == null) return true;

            for (int k = 1; k <= 9; k++) {
                // if this is a valid solution then move to the next
                if (isValidSolution(board, unsolvedLocation[0], unsolvedLocation[1], k)) {
                    board[unsolvedLocation[0]][unsolvedLocation[1]] = Character.forDigit(k, 10);
                    if (solve(board)) return true;
                    board[unsolvedLocation[0]][unsolvedLocation[1]] = '.';
                }
            }
            return false;
        }

        private int[] SearchForUnsolvedLocation(char[][] board) {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (board[i][j] == '.') return new int[]{i, j};
                }
            }
            return null;
        }

        private boolean isValidSolution(char[][] board, int row, int column, int k) {
            return checkColumn(board, row, column, k) && checkRow(board, row, column, k) && checkBox(board, row, column, k);
        }

        private boolean checkColumn(char[][] board, int row, int column, int k) {
            char chark = Character.forDigit(k, 10);
            for (int i = 0; i < ROWS; i++) {
                if (chark == board[i][column]) return false;
            }
            return true;
        }

        private boolean checkRow(char[][] board, int row, int column, int k) {
            char chark = Character.forDigit(k, 10);
            for (int i = 0; i < ROWS; i++) {
                if (board[row][i] == chark) return false;
            }
            return true;
        }

        private boolean checkBox(char[][] board, int row, int column, int k) {
            char chark = Character.forDigit(k, 10);
            int boxStartRow = row - row % 3;
            int boxStartCol = column - column % 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (chark == board[i + boxStartRow][j + boxStartCol]) return false;
                }
            }
            return true;
        }
    }
}