import java.util.*;

/**
 * Created by abhijeet on 5/23/2016.
 * Reference solution : https://discuss.leetcode.com/topic/28641/my-16ms-c-code
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [[-1,  0, 0, 1], [-2, -1, 1, 2], [-2,  0, 0, 2]]
 */
public class FourSum {
    public static void main(String[] args) {

        int[] nums = {5, 5, 3, 5, 1, -5, 1, -2};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(nums, 4);

        for (List<Integer> partialResult : result) {
            for (Integer i : partialResult) {
                System.out.printf(i + " ");
            }
            System.out.printf("\n");
        }
    }

    public static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[left]);
                            list.add(nums[right]);
                            result.add(list);
                            left++;
                            right--;
                            while (right >= 0 && nums[right + 1] == nums[right]) right--;
                            while (left < nums.length && nums[left - 1] == nums[left]) left++;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }

            }
            return result;
        }
    }
}
