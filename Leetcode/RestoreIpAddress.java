import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 10/17/16.
 * https://leetcode.com/problems/restore-ip-addresses/
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIpAddress {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("0279245587303");
        System.out.println(result);
    }

    public static class Solution {
        List<String> result = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
            solve(s, 0, 0, "");
            return result;
        }

        private boolean solve(String s, int index, int dotCount, String sb) {
            // we have added three dots, we have to take rest of the characters in the string
            if(dotCount == 3) {
                String subString = s.substring(index);
                if(subString.length() > 3 || subString.equals("") || Long.parseLong(subString) > 255) return false;
                if(isValid(subString))
                    result.add(sb + "." + subString);
                return true;
            }

            for (int i = 1; i <= 3; i++) {
                if(index + i <= s.length()) {
                    String str = s.substring(index, index + i);
                    if(isValid(str)) {
                        String partialSolution = sb.equals("") ? str : sb + "." + str;
                        solve(s, index + i, dotCount + 1, partialSolution);
                    }
                }
            }
            return true;
        }

        private boolean isValid(String str) {
            int value = Integer.parseInt(str);
            if(value > 255) return false;
            if(str.length() == 2 && value < 10 ) return false;
            if(str.length() == 3 && value < 100) return false;
            return true;
        }
    }
}