import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abhijeet on 11/8/2015.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] list = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
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
            int begin = 0 ;
            int end = nums.length-1;
            Set set = new HashSet();

            while (begin < end) {
                int remains = 0 - (nums[begin]+nums[end]);
                int found = binarySearch(nums, begin+1, end-1, remains);

                if (found != -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[begin]);
                    list.add(nums[found]);
                    list.add(nums[end]);

                    String key = Arrays.toString(list.toArray());
                    if (!set.contains(key)) {
                        set.add(key);
                        solution.add(list);
                    }
                }

                if (remains > 0){
                    begin++;
                } else if (remains == 0) {
                    begin++;
                    end++;
                }
                else {
                    end--;
                }

            }
            return solution;
        }

        public int binarySearch(int[] nums, int begin, int end, int searchMe) {
            while (begin <= end) {
                int mid = (begin+end)/2;
                 if(nums[mid] == searchMe) {
                     return mid;
                 } else if (searchMe < nums[mid]) {
                    end = mid-1;
                } else {
                     begin = mid+1;
                 }

            }
            return -1;
        }
    }
}
