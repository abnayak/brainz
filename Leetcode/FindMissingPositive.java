import java.util.Collections;

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
        int[] array = {1};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(array));
    }

    public static class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while(nums[i] > 0 && nums[i]-1 < nums.length && nums[nums[i]-1] != nums[i]) {
                    int temp = nums[nums[i]-1];;
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
            int i =0;
            for (; i < nums.length; i++) {
                if(nums[i] != i+1) break;
            }

            return i+1;
        }
    }
}
