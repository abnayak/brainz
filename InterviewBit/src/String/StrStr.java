package String;

/**
 * Created by abhijeet on 3/17/16.
 *  https://www.interviewbit.com/problems/implement-strstr/
 */
public class StrStr {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "Abhijeet nayak";
        String needle= "sdlfj";
        System.out.println(solution.strStr(haystack, needle));
    }

    public static class Solution {
        public int strStr(final String haystack, final String needle) {
            if(needle == null || needle.length() > haystack.length() || haystack == null) {
                return -1;
            }
            for(int i = 0 ; i <= haystack.length() - needle.length(); i++) {
                for(int j = 0; j < needle.length(); j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }
                    if(j+1 == needle.length()) return i;
                }
            }
            return -1;
        }
    }
}
