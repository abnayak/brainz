/**
 * Created by abhijeet on 8/23/16.
 */
public class AtoI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("-2147483648"));
    }

    public static class Solution {
        public int myAtoi(String str) {
            if (str == null) return 0;

            str = str.trim();
            if (str.length() == 0) return 0;

            int multiply = 1;
            int index = 0;
            if (str.charAt(index) == '-') {
                multiply = -1;
                index++;
            } else if (str.charAt(index) == '+') {
                index++;
            }

            int result = 0;
            int previous = 0;
            for (int i = index; i < str.length(); i++) {
                previous = result;
                int addition = (str.charAt(i) - '0');
                result = result * 10 + addition;
                System.out.println(result + " " + previous);
                if (result / 10 != previous) {
                    return 0;
                }
            }
            return result * multiply;
        }
    }
}
