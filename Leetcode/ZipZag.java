/**
 * Created by abhijeet on 8/22/16.
 * https://leetcode.com/problems/zigzag-conversion/
 *
 *
 */
public class ZipZag {
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        Solution solution = new Solution();
        solution.convert(input, 3);
    }

    public static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }

            StringBuffer[] rows = new StringBuffer[numRows];
            for (int i = 0; i < numRows; i++) {
                rows[i] = new StringBuffer();
            }

            int index = -1;
            int increment = 1;
            for (int i = 0; i < s.length(); i++) {
                index = index + increment;
                rows[index].append(s.charAt(i));
                if (index == 0) {
                    increment = 1;
                }
                if (index == numRows - 1) {
                    increment = -1;
                }
            }

            for (int i = 1; i < numRows; i++) {
                rows[0].append(rows[i].toString());
            }
            return rows[0].toString();
        }
    }
}
