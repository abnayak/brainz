/**
 * Created by abhijeet on 8/23/16.
 * https://leetcode.com/problems/palindrome-number/
 */
public class PallindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
    }
    public static class Solution {
        public boolean isPalindrome(int x) {
            if( x < 0 || x%10 == 0 && x != 0) return false;

            int i = x;
            int count =0;
            while ( i != 0) {
                count++;
                i /= 10;
            }

            int reverse = 0;
            for(i =1; i <= count/2; i++) {
                reverse = (reverse * 10) + (x %10);
                x /= 10;
            }
            if( count % 2 != 0) x /= 10;

            return x == reverse;
        }

    }
}
