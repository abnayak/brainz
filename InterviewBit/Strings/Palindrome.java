package Strings;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Example:
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class Palindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.isPalindrome("");
        System.out.println(result);
    }

    public static class Solution {
        public int isPalindrome(String A) {
            if (A == null) {
                return 0;
            }
            if (A.length() == 0 || A.length() == 1) {
                return 1;
            }

            A = A.toLowerCase();
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < A.length(); i++) {
                char ch = A.charAt(i);
                if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                    sb.append(ch);
                }
            }

            A = sb.toString();

            int i = 0;
            int j = A.length() - 1;

            while (i < j) {
                if (A.charAt(i) != A.charAt(j)) {
                    return 0;
                }
                i++;
                j--;
            }
            return 1;
        }
    }

}
