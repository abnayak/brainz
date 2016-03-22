package String;

/**
 * Created by abhijeet on 3/22/16.
 */
public class AddBinaryString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("111111111", "11"));
    }

    public static class Solution {
        public String addBinary(String a, String b) {
            int len = a.length() > b.length() ? a.length() : b.length();
            int[] solution = new int[len+1];

            String x = new StringBuilder(a).reverse().toString();
            String y = new StringBuilder(b).reverse().toString();

            for(int i= 0; i < len ; i++) {
                int sum = 0;
                if(i < x.length() && i < y.length())
                    sum = Character.getNumericValue(x.charAt(i)) + Character.getNumericValue(y.charAt(i));
                else if(i < x.length() && i >= y.length())
                    sum = Character.getNumericValue(x.charAt(i));
                else if(i >= x.length() && i< y.length())
                    sum =  Character.getNumericValue(y.charAt(i));

                sum += solution[i];

                solution[i] = sum % 2;
                solution[i+1] = sum / 2;
            }

            // Remove trailing zeros
            StringBuilder newSolution = new StringBuilder();
            for(int i = solution.length-1; i >= 0; i--) {
                if(solution[i] == 0) {
                    continue;
                } else {
                    while(i>=0) {
                        newSolution.append(Character.forDigit(solution[i], 10));
                        i--;
                    }
                }
            }

            if (newSolution.length() == 0) {
                return "0";
            } else {
                return newSolution.toString();
            }
        }
    }
}
