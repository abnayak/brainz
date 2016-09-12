/**
 * Created by abhijeet on 9/11/16.
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public class Solution {
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

            if(solution.length() == 0) return "0";

            return solution.toString();
        }
    }
}
