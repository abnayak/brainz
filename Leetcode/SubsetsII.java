import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhijeet on 10/16/16.
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    public class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            solve(new ArrayList<>(), nums, 0);
            return result;
        }

        private void solve(List<Integer> partialSolution, int[] nums, int index) {
            if (index >= nums.length) {
                result.add(new ArrayList(partialSolution));
                return;
            }

            // take the current number
            partialSolution.add(nums[index]);
            solve(partialSolution, nums, index + 1);

            while(index + 1 < nums.length && nums[index] == nums[index+1]) index++;

            // do not take the current number
            partialSolution.remove(partialSolution.size()-1);
            solve(partialSolution, nums, index + 1);
        }
    }
}
