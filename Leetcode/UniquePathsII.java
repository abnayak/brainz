/**
 * Created by abhijeet on 9/18/16.
 * https://leetcode.com/problems/unique-paths-ii/
 * Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 */
public class UniquePathsII {
    public static void main(String[] args) {

    }

    public class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length;
            int m = obstacleGrid[0].length;

            int[][] pathCountGrid = new int[n][m];
            pathCountGrid[0][0] = obstacleGrid[0][0]  == 0 ? 1 : -1;
            // fill the first row
            for (int i = 1; i < m; i++) {
                if (obstacleGrid[0][i] == 1) {
                    pathCountGrid[0][i] = -1;
                } else {
                    // if previous column is -ve that implies there is obstacle
                    if (pathCountGrid[0][i - 1] >= 0) {
                        pathCountGrid[0][i] = 1;
                    } else {
                        pathCountGrid[0][i] = -1;
                    }
                }
            }

            // fill the first column
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[i][0] == 1) {
                    pathCountGrid[i][0] = -1;
                } else {
                    // if previous column is -ve that implies there is obstacle
                    if (pathCountGrid[i - 1][0] >= 0) {
                        pathCountGrid[i][0] = 1;
                    } else {
                        pathCountGrid[i][0] = -1;
                    }
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        pathCountGrid[i][j] = -1;
                    } else {
                        int upperRowPathCount = pathCountGrid[i - 1][j] > 0 ? pathCountGrid[i - 1][j] : 0;
                        int leftColumnPathCount = pathCountGrid[i][j-1] > 0 ? pathCountGrid[i][j-1] : 0;
                        pathCountGrid[i][j]  = upperRowPathCount + leftColumnPathCount;
                    }
                }
            }
            return pathCountGrid[n-1][m-1] > 0 ? pathCountGrid[n-1][m-1] : 0;
        }
    }
}
