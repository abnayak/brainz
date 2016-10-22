package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 10/20/16.
 */
public class LetterPhone {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("0");

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static class Solution {
        String[] numberToStringMap = new String[10];
        ArrayList<String> result;

        public ArrayList<String> letterCombinations(String a) {
            if (a == null || a.length() == 0) return result;
            result = new ArrayList<>();

            numberToStringMap[0] = "";
            numberToStringMap[1] = "";
            numberToStringMap[2] = "abc";
            numberToStringMap[3] = "def";
            numberToStringMap[4] = "ghi";
            numberToStringMap[5] = "jkl";
            numberToStringMap[6] = "mno";
            numberToStringMap[7] = "pqrs";
            numberToStringMap[8] = "tuv";
            numberToStringMap[9] = "wxyz";

            findSolutions(a, 0, "");

            return result;
        }

        private void findSolutions(String a, int index, String partialSolution) {
            if (index >= a.length()) {
                if (partialSolution.length() > 0) {
                    result.add(partialSolution);
                }
                return;
            }

            int number = Character.getNumericValue(a.charAt(index));

            if (number >= 2 && number <= 9) {
                String str = numberToStringMap[number];
                for (int i = 0; i < str.length(); i++) {
                    findSolutions(a, index + 1, partialSolution + str.charAt(i));
                }
            } else {
                findSolutions(a, index + 1, partialSolution);
            }

        }

    }

}
