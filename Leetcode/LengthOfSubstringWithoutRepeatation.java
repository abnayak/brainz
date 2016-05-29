import java.util.HashMap;
import java.util.Map;

/**
 https://leetcode.com/problems/longest-substring-without-repeating-characters/

 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LengthOfSubstringWithoutRepeatation {
    public static void main (String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        System.out.printf("length: " + solution.lengthOfLongestSubstring(s));
    }

    public static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int i = 0;
            int j = 0;
            int global_max = 0;
            Map<Character, Integer> map = new HashMap<>();

            while ( i < s.length() && j < s.length()) {
                if(!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), j);
                    j++;
                } else {
                    if(map.get(s.charAt(j)) >=  i) {
                        i = map.get(s.charAt(j)) + 1;
                    }
                    map.put(s.charAt(j), j);
                    j++;
                }
                global_max = Math.max(global_max, j - i);
            }
            return global_max;
        }
    }
}
