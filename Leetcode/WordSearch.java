/**
 * Created by abhijeet on 9/20/16.
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] array = {{'a'}};
        Solution solution = new Solution();
        System.out.println(solution.exist(array, "a"));
    }

    public static class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean found = search(board, i, j, word, 0, new int[board.length + 1][board[0].length + 1]);
                        if (found) return found;
                    }
                }
            }
            return false;
        }

        private boolean search(char[][] board, int i, int j, String word, int wordIndex, int[][] check) {
            if (wordIndex == word.length()) return true;

            if (j < 0 || i < 0 || j >= board[0].length || i >= board.length) return false;

            if (check[i][j] == 1) return false;

            if (board[i][j] == word.charAt(wordIndex)) return false;

            check[i][j] = 1;

            if (search(board, i, j + 1, word, wordIndex + 1, check)) return true;
            if (search(board, i + 1, j, word, wordIndex + 1, check)) return true;
            if (search(board, i - 1, j, word, wordIndex + 1, check)) return true;
            if (search(board, i, j - 1, word, wordIndex + 1, check)) return true;

            check[i][j] = 0;

        }
    }
}
