import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 8/29/16.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("23");
        for(String str : result) {
            System.out.println(str);
        }
    }

    public static class Solution {
        private List<String> result;
        private final char[][] numberToCharMap = new char[][]{
                {' '},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0) {
                return new ArrayList<String>();
            }

            result = new ArrayList<>();
            char[] chArray = digits.toCharArray();
            char[] combination = new char[digits.length()];

            helper(chArray, 0, combination);
            return result;
        }

        public void helper(char[] digits, int index, char[] combination) {
            if (index == digits.length) {
                result.add(new String(combination));
                return;
            }

            int number = digits[index] - '0';

            for (int i = 0; i < numberToCharMap[number].length; i++) {
                combination[index] = numberToCharMap[number][i];
                helper(digits, index + 1, combination);
            }
        }
    }
}
