/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of
money you can rob tonight without alerting the police.

https://leetcode.com/problems/house-robber/
*/

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] input = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78};
        Solution solution = new Solution();
        System.out.println(solution.rob(input));
    }

    public static class Solution {
        private int[] robbery;

        public int rob(int[] nums) {
            robbery = new int[nums.length];
            Arrays.fill(robbery, -1);
            return robHelper(nums, 0);
        }

        public int robHelper(int[] nums, int index) {
            if(index >= nums.length) {
                return 0;
            }
            if(robbery[index] != -1) {
                return robbery[index];
            }

            robbery[index] = Math.max(nums[index] + robHelper(nums, index+2), robHelper(nums, index+1));
            return robbery[index];
        }
    }
}
