/**
 * Created by abhijeet on 11/7/2015.
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] array = {2,3,-2,4};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(array));
    }

    public static class Solution {
        public int maxProduct(int[] nums) {
            int previousMax = nums[0];
            int previousMin = nums[0];
            int globalMax  = nums[0];

            for(int index = 1; index < nums.length; index++) {
                int tempPreviousMax = previousMax;
                previousMax = Math.max(Math.max(previousMax*nums[index], nums[index]), previousMin*nums[index]);
                previousMin = Math.min(Math.min(tempPreviousMax*nums[index], nums[index]), previousMin*nums[index]);
                if(previousMax > globalMax) {
                    globalMax = previousMax;
                }
            }
            return globalMax;
        }
    }

}

