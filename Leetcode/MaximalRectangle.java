import java.util.Stack;

/**
 * Created by abhijeet on 10/13/16.
 * https://leetcode.com/problems/maximal-rectangle/
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * For example, given the following matrix:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Return 6.
 */

public class MaximalRectangle {
    public static void main(String[] args) {

    }

    public class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0) return 0;

            int row = matrix.length;
            int col = matrix[0].length;
            int maxArea = 0;

            int[][] intMatrix = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    intMatrix[i][j] = Character.getNumericValue(matrix[i][j]);
                }
            }

            int[][] histogram = new int[row][col];
            for (int i = 0; i < col; i++) {
                histogram[0][i] = intMatrix[0][i];
            }

            // apply the get get histogram area method to get the area
            int tempArea = largestRectangleInHistogram(histogram[0]);
            maxArea = tempArea > maxArea ? tempArea : maxArea;

            for (int i = 1; i < row; i++) {
                // build the row of the histogram
                for (int j = 0; j < col; j++) {
                    if(intMatrix[i][j] != 0) {
                        histogram[i][j] = histogram[i - 1][j] + intMatrix[i][j];
                    } else {
                        histogram[i][j] = 0;
                    }
                }
                // apply the get histogram area method to get the area
                tempArea = largestRectangleInHistogram(histogram[i]);
                maxArea = Math.max(tempArea, maxArea);
            }
            return maxArea;
        }

        public int largestRectangleInHistogram(int[] row) {
            int maxArea = 0;
            Stack<Integer> stack = new Stack<>();
            int i;
            for (i = 0; i < row.length; i++) {
                if (stack.isEmpty() || row[stack.peek()] <= row[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && row[stack.peek()] > row[i]) {
                        int topElement = stack.pop();
                        int tempArea;
                        if (stack.isEmpty()) {
                            tempArea = row[topElement] * i;
                        } else {
                            tempArea = row[topElement] * (i - stack.peek() - 1);
                        }
                        maxArea = Math.max(tempArea, maxArea);
                    }
                    stack.push(i);
                }
            }

            while (!stack.isEmpty()) {
                int topElement = stack.pop();
                int tempArea;
                if (stack.isEmpty()) {
                    tempArea = row[topElement] * i;
                } else {
                    tempArea = row[topElement] * (i - stack.peek() - 1);
                }
                maxArea = Math.max(tempArea, maxArea);
            }

            return maxArea;
        }
    }
}
