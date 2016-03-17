/**
 * Created by abhijeet on 11/22/2015.
 */
public class TwoDimentionalArray {
    public static void main (String[] args) {
        int[][] matrix = new int[2][2];
        // Set the matrix
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = i * j;
            }
        }

        // Print the maxtrix
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
