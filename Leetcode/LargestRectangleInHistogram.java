/**
 * Created by abhijeet on 9/21/16.
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {0,2,0};
        System.out.println(solution.largestRectangleArea(array));
    }

    public static class Solution {
        public int largestRectangleArea(int[] heights) {

            int[] count = new int[heights.length];
            int[] area = new int[heights.length];
            int[] minHeight = new int[heights.length];

            count[0] = 1;
            area[0] = heights[0];
            minHeight[0] = heights[0];

            for (int i = 1; i < heights.length; i++) {
                if(heights[i] < minHeight[i-1]) {
                    minHeight[i] = heights[i];
                } else {

                }
            }
            return 0;
        }
    }
}
