package Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhijeet on 3/16/16.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"a", "abfghijk","abcefgh"};
        System.out.println(solution.longestCommonPrefix(new ArrayList<String>(Arrays.asList(strings))));
    }

    public static class Solution {
        public String longestCommonPrefix(ArrayList<String> a) {
            if(a.size() == 1) {
                return a.get(0);
            }

            int prefixMaxLen = a.get(0).length()-1;
            String base = a.get(0);

            for (int i=1; i < a.size(); i++) {
                for(int j=0; j <= prefixMaxLen; j++) {
                    if(j >= a.get(i).length() || a.get(i).charAt(j) != base.charAt(j) ) {
                        prefixMaxLen = j-1;
                    }
                }

            }
            return base.substring(0, prefixMaxLen+1);
        }
    }

}
