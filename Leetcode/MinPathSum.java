/**
 * Created by abhijeet on 9/19/16.
 * https://leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinPathSum {
    public static void main(String[] args) {

    }

    public class Solution {
        public int minPathSum(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] costGrid = new int[n][m];
            costGrid[0][0] = grid[0][0];

            for (int i = 1; i < m; i++) {
                costGrid[0][i] = costGrid[0][i-1] + grid[0][i];
            }

            for (int i = 1; i < n; i++) {
                costGrid[i][0] = costGrid[i-1][0] + grid[i][0];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    int cost = costGrid[i-1][j] >= costGrid[i][j-1] ? costGrid[i][j-1] : costGrid[i-1][j];
                    costGrid[i][j] = cost + grid[i][j];
                }
            }

            return costGrid[n-1][m-1];
        }
    }
}
