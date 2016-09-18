/**
 * Created by abhijeet on 9/18/16.
 */
public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(2,2));
    }
    public static class Solution {
        public int uniquePaths(int m, int n) {
            int[][] grid = new int[m][n];
            for (int i = 0; i < n; i++) {
                grid[0][i] =1;
            }
            for (int i = 0; i < m; i++) {
                grid[i][0] =1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
                }
            }
            return grid[m-1][n-1];
        }
    }
}
