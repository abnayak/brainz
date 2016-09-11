/**
 * Created by abhijeet on 9/10/16.
 * https://leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FindMissingPositive {
    public static void main(String[] args) {
        int[] array = {9,8,6};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(array));
    }

    public static class Solution {
        public int firstMissingPositive(int[] nums) {

            // If there are only negative numbers or zero then first positive number is one.
            boolean onlyNegativeNumbs = true;
            for (int i : nums) {
                if (i > 0) {
                    onlyNegativeNumbs = false;
                    break;
                }
            }
            if (onlyNegativeNumbs) return 1;

            // Check if it's linearly increasing


            // Find the minimum positive number
            int min = Integer.MAX_VALUE;
            for (int i : nums) {
                if (i > 0 && i < min) min = i;
            }
            // Lower the min by 1 which we can subtract from the positive array numbers
            min--;
            int count = 0;
            int actualSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    actualSum += nums[i] - min;
                    count++;
                }
            }
            count++;
            // sum of count+1 elements as one is missing
            int sum = (count * (count + 1)) / 2;
            return (sum - actualSum) + min;
        }
    }
}
