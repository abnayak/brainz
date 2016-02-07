/**
 * Created by abhijeen on 2/8/16.
 */
public class GameOfLife {

    public static class Solution {
        public void gameOfLife(int[] board) {
            board[0] = 10;
            board[1] = 20;
        }
    }

    public static void main(String[] args) {
        int[] board = {1, 2};
        Solution solution = new Solution();
        //solution.gameOfLife(board);
        System.out.println(1 & 1);
    }
}
