import java.util.Stack;

/**
 * Created by abhijeen on 5/27/16.
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Solution: " + solution.isValid("([)]"));
    }

    public static class Solution {
        public boolean isValid(String s) {
            if(s == null || s.equals("")) {
                return true;
            }

            Stack<Character> stack = new Stack<Character>();

            for (int index = 0; index < s.length(); index++) {
                Character bracket = s.charAt(index);
                if (bracket == '(' || bracket == '[' ||
                        bracket == '{') {
                    stack.push(bracket);
                } else {
                    if (!stack.empty()) {
                        if (bracket == ')' && stack.peek() == '(') {
                            stack.pop();
                        } else if (bracket == '}' && stack.peek() == '{') {
                            stack.pop();
                        } else if (bracket == ']' && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
            if (stack.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
