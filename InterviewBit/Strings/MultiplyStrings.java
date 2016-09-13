package Strings;

import java.util.Arrays;

/**
 * Created by abhijeet on 3/21/16.
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
 For example,
 given strings "12", "10", your answer should be “120”.

 NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ).
 We will retroactively disqualify such submissions and the submissions will incur penalties.

 https://www.interviewbit.com/problems/multiply-strings/

 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Solution: " + solution.multiply("99999", "99999"));
    }
    public static class Solution {
        public String multiply(String a, String b) {
            if(a == null || b == null) {
                return null;
            }

            String x = new StringBuilder(a).reverse().toString();
            String y = new StringBuilder(b).reverse().toString();
            int[] reverseSolution = new int[x.length()+y.length()];

            for(int i = 0; i < x.length(); i++) {
                for(int j = 0; j < y.length(); j++) {
                    int sum = reverseSolution[i+j] +
                            Character.getNumericValue(x.charAt(i)) * Character.getNumericValue(y.charAt(j));
                    reverseSolution[i+j] = sum % 10;
                    reverseSolution[i+j+1] += sum / 10; // Add the carry over
                }
            }

            StringBuilder solution = new StringBuilder();

            // Remove trailing zeros
            for(int i = reverseSolution.length-1; i >= 0; i--) {
                if(reverseSolution[i] == 0) {
                    continue;
                } else {
                    while(i>=0) {
                        solution.append(Character.forDigit(reverseSolution[i], 10));
                        i--;
                    }
                }
            }
            return solution.toString();
        }
    }
}
