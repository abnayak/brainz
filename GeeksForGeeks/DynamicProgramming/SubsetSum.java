package DynamicProgramming;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 */
public class SubsetSum {
    private static boolean[] buffer;

    public static boolean subSetSum(int[] input, int sum) {
        buffer = new boolean[sum];
        Arrays.fill(buffer, false);

        return subSetSumHelper(input, 0, sum);
    }

    private static boolean subSetSumHelper(int[] input, int index, int sum) {
        System.out.println("index: " + index + " sum: " + sum);

        if (buffer[index] == true) {
            return true;
        }

        if (sum < 0)
            return false;

        if (sum == 0)
            return true;

        if (index == input.length && sum != 0)
            return false;

        return subSetSumHelper(input, index + 1, sum - input[index]) || subSetSumHelper(input, index + 1, sum);
    }

    public static void main(String[] args) {
        int[] input = {3, 34, 4, 12, 5, 2};
        int sum = 10;
        System.out.println("is sub set sum present: " + subSetSum(input, sum));
    }
}
