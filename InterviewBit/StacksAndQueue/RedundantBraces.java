package StacksAndQueue;

import java.util.Stack;

/**
 * Created by abhijeet on 10/6/16.
 */
public class RedundantBraces {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.braces("(a + (a + b)) * ( c - d)"));
    }

        public static class Solution {
            public int braces(String a) {
                Stack<Character> stack = new Stack<>();
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) == ')') {
                        if (stack.peek() == '(') {
                            return 1;
                        } else {
                            boolean symbolFound = false;
                            while (!stack.isEmpty() && stack.peek() != '(') {
                                Character ch = stack.pop();
                                if(ch == '+' || ch == '-' || ch == '*' || ch == '/') symbolFound = true;
                            }
                            if(!symbolFound) return 1;
                            if (!stack.isEmpty()) stack.pop();
                        }
                    } else {
                        stack.push(a.charAt(i));
                    }
                }
                return 0;
            }
        }
}
