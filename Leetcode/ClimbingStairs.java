import java.util.Arrays;
import java.util.Collections;

/**
 * Created by abhijeet on 9/20/16.
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }

    public static class Solution {
        int[] table;

        public int climbStairs(int n) {
            if( n == 1) return 1;
            if( n == 2) return 2;

            table = new int[n + 1];
            Arrays.fill(table, -1);
            table[n] = 0;
            table[n - 1] = 1;
            table[n - 2] = 2;

            calculate(0, n);
            return table[0];
        }

        private int calculate(int currentLocationOnStair, int totalStairs) {
            if (table[currentLocationOnStair] != -1) {
                return table[currentLocationOnStair];
            }

            int i = 0;
            int j = 0;
            if (currentLocationOnStair + 1 < totalStairs) {
                i = calculate(currentLocationOnStair + 1, totalStairs);
            }
            if (currentLocationOnStair + 2 < totalStairs) {
                j = calculate(currentLocationOnStair + 2, totalStairs);
            }

            table[currentLocationOnStair] = i + j;
            return i + j;
        }
    }

}
