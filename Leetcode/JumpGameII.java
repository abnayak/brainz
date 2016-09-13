/**
 * Created by abhijeet on 9/12/16.
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.jump(array));
    }

    public static class Solution {
        public int jump(int[] nums) {
            int[] count = new int[nums.length];
            count[nums.length - 1] = 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                // Jump to next position
                int min = count[i + 1] + 1;

                // Just as far as possible
                for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
                    if (count[j] + 1 < min) min = count[j] + 1;
                }
                count[i] = min;
            }
            return count[0];
        }
    }
}
