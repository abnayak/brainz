import java.util.*;

/**
 * Created by abhijeet on 9/23/16.
 */
public class RemoveDuplicatesII {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(array));
    }

    public static class Solution {
        public int removeDuplicates(int[] nums) {
            int count = 0;
            int i = 0;
            int len = nums.length;
            while (i < len) {
                nums[count++] = nums[i++];
                if (i < len && nums[i - 1] == nums[i]) {
                    nums[count++] = nums[i++];
                    while (i < len && nums[i - 1] == nums[i]) i++;
                }
            }
            return count;
        }
    }
}
