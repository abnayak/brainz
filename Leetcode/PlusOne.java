import java.util.LinkedList;

/**
 * Created by abhijeet on 9/19/16.
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] number = {9};
        int[] array = solution.plusOne(number);
        for (int i : array) {
            System.out.printf("%d ", i);
        }
    }

    public static class Solution {
        public int[] plusOne(int[] digits) {
            LinkedList<Integer> result = new LinkedList<>();

            int carry = 1;
            int sum = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                sum = carry + digits[i];
                carry = sum / 10;
                result.addFirst(sum % 10);
            }
            if (carry != 0) {
                result.addFirst(carry);
            }
            int[] intResult = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                intResult[i] = result.get(i);
            }

            return intResult;
        }
    }
}
