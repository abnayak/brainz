package BitManipulation;

/**
 * Created by abhijeet on 9/26/16.
 */
public class ReverseBits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(3));
    }

    public static class Solution {
        public long reverse(long a) {
            String s = Long.toBinaryString(a);
            int[] binary = new int[32];
            int j = s.length() -1;
            int i = 0;
            while(j >= 0) {
                binary[i++] = s.charAt(j--) - '0';
            }
            long result = 0;
            for(i = 0 ; i < 32 ; i++) {
                result += binary[i] * Math.pow(2, 31 - i);
            }
            return result;
        }
    }

}
