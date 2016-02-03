import java.util.Arrays;

/**
 * Created by abhijeet on 11/22/2015.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public static void main (String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,1};
        int target = -100;
        System.out.println(solution.threeSumClosest(nums, target));
    }

    public static class Solution {
        public int threeSumClosest (final int[] nums, int target) {
            int solution;
            Arrays.sort(nums);
            int len = nums.length - 3;
            solution = nums[len] + nums[len+1] + nums[len+2];

            for (int i = 0; i <= len; i++) {
                int low = i + 1;
                int high = nums.length - 1;

                while (low < high) {
                    int temp = nums[i] + nums[low] + nums[high];
                    int distance1 = distance(target, temp);
                    int distance2 = distance(target, solution);

                    if (distance1 < distance2) {
                        solution = temp;
                    }

                    if (temp > target) {
                        high--;
                    } else if (temp < target) {
                        low++;
                    } else if (temp == target) {
                        return temp;
                    }
                }
            }
            return solution;
        }

        private int distance (int a, int b) {
            if (a > b) {
                return a - b;
            } else {
                return b - a;
            }
        }
    }
}
