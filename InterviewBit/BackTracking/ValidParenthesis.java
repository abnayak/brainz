package BackTracking;

import java.util.ArrayList;

/**
 * Created by abhijeet on 10/20/16.
 * https://www.interviewbit.com/problems/generate-all-parentheses-ii/
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> result = solution.generateParenthesis(3);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static class Solution {
        ArrayList<String> result = new ArrayList<>();

        public ArrayList<String> generateParenthesis(int a) {
            if (a == 0) return result;
            findSolutions("", a, 0);
            return result;
        }

        private void findSolutions(String string, int a, int count) {
            if (a == 0 && count == 0) {
                if (string != null && string.length() > 0) {
                    result.add(string);
                    return;
                }
            }

            if (a > 0) {
                findSolutions(string + "(", a - 1, count + 1);
            }

            if (count > 0) {
                findSolutions(string + ")", a, count - 1);
            }
        }
    }
}
