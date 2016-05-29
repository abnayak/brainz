package Strings;

/**
 * Created by abhijeet on 3/20/16.
 * https://www.interviewbit.com/problems/longest-palindromic-substring/
 * Given a string S, find the longest palindromic substring in S.

 Substring of string S:

 S[i...j] where 0 <= i <= j < len(S)

 Palindrome string:

 A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

 Incase of conflict, return the substring which occurs first ( with the least starting index ).
 */
public class LongestPalindromicString {
    public static void main(String[] args) {
        String input = "aaaabaaa";
        Solution solution = new Solution();
        System.out.println("Palindromic SubString :" + solution.longestPalindrome(input));
    }
    public static class Solution {
        public String longestPalindrome(String a) {
            if(a.length() == 0) {
                return null;
            }

            int maxLen = 0;
            int beingIndex = -1;
            int endIndex = -1;

            for(int i=0; i < a.length()-1; i++) {

                // Case - 1, odd pallindromic string
                int back = i;
                int forward = i;
                int tempMaxLen = 0;
                while ( back >= 0 && forward < a.length()) {
                    if(a.charAt(back) == a.charAt(forward)) {
                        if((forward - back) + 1 >= tempMaxLen) {
                            tempMaxLen = (forward - back) +1;
                        }
                        if(tempMaxLen > maxLen) {
                            maxLen = tempMaxLen;
                            beingIndex = back;
                            endIndex = forward;
                        }
                        back--;
                        forward++;
                    } else {
                        break;
                    }
                }

                // case - 2 even pallindromic string
                back = i;
                forward = i+1;
                tempMaxLen = 0;
                while(back >= 0 && forward < a.length()) {
                    if(a.charAt(back) == a.charAt(forward)) {
                        if((forward - back) +1 >= 0) {
                            tempMaxLen = (forward - back) +1;
                        }
                        if(tempMaxLen > maxLen) {
                            maxLen = tempMaxLen;
                            beingIndex = back;
                            endIndex = forward;
                        }
                        back--;
                        forward++;
                    } else {
                        break;
                    }
                }

            }

            if(beingIndex == endIndex) {
                return a.substring(0,1);
            }
            return a.substring(beingIndex, endIndex+1);
        }
    }
}
