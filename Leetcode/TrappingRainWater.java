/**
 * Created by abhijeet on 11/6/2015.

 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 https://leetcode.com/problems/trapping-rain-water/
 */

public class TrappingRainWater {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println("trapped water: " + solution.trap(height));

    }

    public static class Solution {
        public int trap(int[] height) {
            int sum = 0;
            int[] maxHeightFromStart = new int[height.length];
            int[] maxHeightFromEnd = new int[height.length];
            int[] storedWater = new int[height.length];

            // If there are only two bars, there is no way you can store water with this.
            if( height.length < 3) return 0;

            // Find the max height to the left of current index
            maxHeightFromStart[0] = height[0];
            for (int index = 1; index < height.length; index++) {
                if (height[index-1] > maxHeightFromStart[index-1]) {
                    maxHeightFromStart[index] = height[index-1];
                } else {
                    maxHeightFromStart[index] = maxHeightFromStart[index-1];
                }
            }

            // Find the max height to the right of current index
            int endIndex = height.length-1;
            maxHeightFromEnd[endIndex] = height[endIndex];
            for(int index = endIndex-1; index >= 0; index--) {
                if(height[index+1] > maxHeightFromEnd[index+1]) {
                    maxHeightFromEnd[index] = height[index+1];
                } else {
                    maxHeightFromEnd[index] = maxHeightFromEnd[index+1];
                }
            }

            // If height if current index is lower than the max height to left and right then only we will store water
            for(int index = 0; index < height.length; index++) {
                if(height[index] < Math.min(maxHeightFromStart[index], maxHeightFromEnd[index])) {
                    storedWater[index] = Math.min(maxHeightFromStart[index], maxHeightFromEnd[index]) - height[index];
                } else {
                    storedWater[index] = 0;
                }
            }


            for(int index = 0; index < height.length; index++) {
                sum += storedWater[index];
            }
            return sum;
        }
    }
}
