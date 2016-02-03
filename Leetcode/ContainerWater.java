/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines
        are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with
        x-axis forms a container, such that the container contains the most water.

        Note: You may not slant the container.
*/

public class ContainerWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[10];
        System.out.println(solution.maxArea(array));
    }

    private static class Solution {
        public int maxArea(int[] height) {
            return 0;
        }
    }

}
