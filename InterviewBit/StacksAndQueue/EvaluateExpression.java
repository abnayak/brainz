package StacksAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by abhijeet on 10/12/16.
 */
public class EvaluateExpression {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        String[] array = {"2", "2", "/"};
        for (String s : array) {
            a.add(s);
        }
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(a));
    }

    public static class Solution {
        public int evalRPN(ArrayList<String> a) {
            Stack<String> stack = new Stack<>();
            for (String s : a) {
                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    String operand2 = stack.pop();
                    String operand1 = stack.pop();
                    int result = calculate(operand1, operand2, s);
                    stack.push(Integer.toString(result));
                } else {
                    stack.push(s);
                }
            }
            return Integer.parseInt(stack.pop());
        }

        private int calculate(String first, String second, String operator) {
            int a = Integer.parseInt(first);
            int b = Integer.parseInt(second);
            switch (operator) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    return a / b;
            }
            return 0;
        }
    }
}
