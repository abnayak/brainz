package Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhijeet on 3/16/16.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"abfghijk", "ab", "abcefgh"};
        System.out.println(solution.longestCommonPrefix(new ArrayList<String>(Arrays.asList(strings))));
    }

    public static class Solution {
        public String longestCommonPrefix(ArrayList<String> a) {
            if (a.size() == 0) {
                return "";
            }

            if (a.size() == 1) {
                return a.get(0);
            }

            int maxStringLength = Integer.MAX_VALUE;
            for (String string : a) {
                if (string.length() < maxStringLength) {
                    maxStringLength = string.length();
                }
            }

            int endIndex;
            for (int i = 0; i < maxStringLength; i++) {
                char ch = a.get(0).charAt(i);
                for (int j = 1; j < a.size(); j++) {
                    if (ch != a.get(j).charAt(i)) {
                        return a.get(0).substring(0, i);
                    }
                }
            }

            return a.get(0).substring(0, maxStringLength);
        }
    }

}
