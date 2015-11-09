import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhijeet on 11/7/2015.
 */
public class HouseRobberTwo {
    public static void main(String[] args) {
        int[] input = {1,1,1,1};
        Solution solution = new Solution();
        System.out.println(solution.rob(input));
    }

    public static class Solution {
        private int[] robbery;
        private List<Integer> list;
        public int rob(int[] nums) {
            robbery = new int[nums.length];
            Arrays.fill(robbery, -1);
            list = new LinkedList<>();
            return robHelper(nums, 0);
        }

        public int robHelper(int[] nums, int index) {
            if(index >= nums.length) {
                return 0;
            }

            if(robbery[index] != -1) {
                return robbery[index];
            }

            if(nums.length > 3 && index == nums.length-3 && list.size() > 0 && list.get(0) != 0) {
                return nums[nums.length-1];
            } else if (nums.length <= 3) {
                if (nums.length == 1)
                    return nums[0];
                else if ( nums.length ==2) {
                    return Math.max(nums[0], nums[1]);
                }
                 else {
                    return Math.max(Math.max(nums[0], nums[1]), nums[2]);
                }
            }


            list.add(index);
            int val1  = nums[index] + robHelper(nums, index+2);

            list.remove(list.size()-1);
            int val2 = robHelper(nums, index+1);

            return robbery[index] = Math.max(val1, val2);
        }
    }
}
