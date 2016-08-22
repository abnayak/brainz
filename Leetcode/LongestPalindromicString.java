/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Created by abhijeet on 8/19/16.
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.`
 */
public class LongestPalindromicString {
    public static void main(String[] args) {
        System.out.println(Solution.longestPalindrome("ctc"));
    }

    public static class Solution {
        public static String longestPalindrome(String s) {
            if (s.length() == 1) {
                return s;
            }
            String solution = "";

            for (int i = 1; i < s.length(); i++) {
                // Consider string middle is at i
                solution = helper(s, i - 1, i + 1, solution);

                // Consider the string with even length
                solution = helper(s, i - 1, i, solution);
            }
            return solution;
        }

        private static String helper(String s, int left, int right, String solution) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            left++;
            right--;
            if ((right - left) + 1 > solution.length()) {
                return s.substring(left, right+1);
            } else {
                return solution;
            }
        }
    }
}
