import java.math.BigInteger;

/**
 * Created by abhijeet on 8/22/16.
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-2147483412));
    }

    public static class Solution {
        public int reverse(int x) {
            int multiply = x < 0 ? -1 : 1;
            x *= multiply;

            int result = 0;
            int previous;
            while (x > 0) {
                previous = result;
                result = result * 10 + x % 10;
                if (result / 10 != previous) {
                    return 0;
                }
                x /= 10;
            }

            return result * multiply;
        }
    }
}
