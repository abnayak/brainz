package BitManipulation;

/**
 * Created by abhijeet on 9/26/16.
 * https://www.interviewbit.com/problems/number-of-1-bits/
 * Write a function that takes an unsigned integer and returns the number of 1 bits it has.
 * <p>
 * Example:
 * <p>
 * The 32-bit integer 11 has binary representation
 * <p>
 * 00000000000000000000000000001011
 * so the function should return 3.
 * <p>
 * Note that since Java does not have unsigned int, use long for Java
 */
public class NumberOneBits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSetBits(11));
    }

    public static class Solution {
        public int numSetBits(long a) {
            String s = Long.toBinaryString(a);
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') count++;
            }
            return count;
        }
    }
}
