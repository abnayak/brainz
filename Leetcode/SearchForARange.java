import src.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhijeet on 9/6/16.
 */
public class SearchForARange {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 2, 3};

        int[] list = solution.searchRange(array, 2);
        System.out.println("Begin: " + list[0] + " End: " + list[1]);
    }

    public static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] solution = {-1, -1};
            if (nums == null || nums.length == 0) return solution;

            //List<Integer> list = new ArrayList<>();
            //for (int num : nums) list.add(num);

            int index = BinarySearch(nums, target);
            if (index < 0) return solution;

            int begin = index;
            int end = index;
            while (begin - 1 >= 0 && nums[begin] == nums[begin - 1]) begin--;
            while (end + 1 < nums.length && nums[end] == nums[end + 1]) end++;

            solution[0] = begin;
            solution[1] = end;

            return solution;
        }
        private int BinarySearch(int[] nums, int target) {
            int begin = 0;
            int end = nums.length - 1;
            int mid = (begin + end) / 2;
            while (begin <= end) {
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = (begin + end) / 2;
            }
            return -1;
        }
    }


}
