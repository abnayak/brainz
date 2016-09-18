import java.util.Arrays;

/**
 * Created by abhijeet on 9/16/16.
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] posts = {3, 2, 1, 1, 4};
        System.out.println("is there a path to end: " + solution.canJump(posts));
    }

    public static class Solution {
        public boolean canJump(int[] nums) {
            return solveV2(nums);
        }

        /**
         * Most efficient method to solve this problem.
         * @param nums
         * @return
         */
        public boolean solveV2(int[] nums) {
            int maxReachable = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if(maxReachable < i) return false;
                maxReachable = Math.max(maxReachable, i+nums[i]);
            }
            return true;
        }

        /**
         * Using extra space to cache the previous results
         * @param nums
         * @return
         */
        public boolean solveV1(int[] nums) {
            boolean[] array = new boolean[nums.length];
            Arrays.fill(array,false);
            array[nums.length-1] = true;

            for (int i = nums.length - 2; i >= 0; i--) {
                for (int j = nums[i]; j >= 1; j--) {
                    int tempIndex = i + j;
                    if (tempIndex >= nums.length - 1 || array[tempIndex]) {
                        array[i] = true;
                        continue;
                    }
                }
            }
            return array[0];
        }
    }
}
