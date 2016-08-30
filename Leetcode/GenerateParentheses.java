import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 8/30/16.
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.generateParenthesis(0);
        for(String str : result) {
            System.out.println(str);
        }
    }

    public static class Solution {
        List<String> result;

        public List<String> generateParenthesis(int n) {
            result = new ArrayList<>();
            char[] solution = new char[n * 2];
            helper(solution, 0, 0, n, 0, 0);
            return result;
        }

        public void helper(char[] solution, int index, int count, int n, int leftBracketCount, int rightBracketCount) {
            if (index == n * 2) {
                result.add(new String(solution));
                return;
            }

            if (leftBracketCount < n) {
                solution[index] = '(';
                helper(solution, index + 1, count + 1, n, leftBracketCount + 1, rightBracketCount);
            }

            if (count - 1 >= 0 && rightBracketCount < n) {
                solution[index] = ')';
                helper(solution, index + 1, count - 1, n, leftBracketCount, rightBracketCount + 1);
            }
        }
    }
}
