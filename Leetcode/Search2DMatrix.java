/**
 * Created by abhijeet on 9/20/16.
 */
public class Search2DMatrix {
    public static void main(String[] args) {
    }

    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int total = m * n;

            int start = 0;
            int end = total;
            int mid;
            while (start <= end) {
                mid = (start + end) / 2;
                int midElement = matrix[total/n][total%n];
                if(midElement == target) {
                    return true;
                } else if(midElement < target) {
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
            return false;
        }
    }
}
