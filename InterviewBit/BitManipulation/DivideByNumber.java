package BitManipulation;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by abhijeet on 9/29/16.
 */
public class DivideByNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(-2147483648, -1));
    }

    public static class Solution {
        public int divide(int dividend, int divisor) {
            long a = dividend;
            long b = divisor;

            a = Math.abs(a);
            b = Math.abs(b);
            long result = 0;

            if (b > a) return 0;
            while (a >= b) {
                result++;
                a -= b;
            }
            if( (dividend < 0 && divisor > 0) || (dividend > 0  && divisor < 0)) {
                return -1 * (int)result;
            }
            if(result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            return (int)result;
        }
    }
}
