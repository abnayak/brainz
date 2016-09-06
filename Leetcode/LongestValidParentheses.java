/**
 * Created by abhijeet on 9/5/16.
 * https://leetcode.com/submissions/detail/73143304/
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")()())()()("));
    }

    public static class Solution {
        private class Pair {
            public char key;
            public int value;

            public Pair(char key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public int longestValidParentheses(String s) {
            // Stack<Pair> stack = new Stack<>();
            Pair[] stack = new Pair[s.length()];
            int stackIndex = -1;
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack[++stackIndex] = new Pair('(', i);
                } else if (s.charAt(i) == ')') {
                    if (stackIndex != -1 && stack[stackIndex].key == '(') {
                        stackIndex--;

                        int newLen = 0;
                        // If stack is empty, that means we have a perfect brackets till i
                        // else subtract from the top element in the stack
                        if (stackIndex == -1) newLen = i + 1;
                        else newLen = (i - stack[stackIndex].value);

                        if (newLen > max) max = newLen;
                    } else {
                        stack[++stackIndex] = new Pair(')', i);
                    }
                }
            }
            return max;
        }
    }
}
