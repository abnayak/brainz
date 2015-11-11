import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by abhijeet on 11/10/2015.
 */
public class ThreeSumV2 {
    public static void main(String[] args) {
        int[] list = {1,-1,-1,0}; // -1 -1 0 1
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(list);
        for(List<Integer> i : result) {
            for(int j: i) {
                System.out.print(j + ", ");
            }
            System.out.println("\n");
        }
    }
    public static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> solution = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length-3;
            for(int i = 0; i <= len ;) {

                int low = i+1;
                int high = nums.length-1;

                while(low < high) {
                    if (nums[i] + nums[low] + nums[high] > 0) {
                        high--;
                    } else if (nums[i] + nums[low] + nums[high] < 0) {
                        low++;
                    } else if(nums[i] + nums[low] + nums[high] == 0) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        solution.add(temp);
                        low++;
                        high--;
                        while(low < high && nums[low] == nums[low-1] && nums[high] == nums[high+1]) {
                            low++;
                            high--;
                        }
                    }
                }
                i++;
                while (i <= len && nums[i] == nums[i-1]) {
                    i++;
                }
            }
            return solution;
        }
    }
}
