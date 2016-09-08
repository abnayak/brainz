import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by abhijeet on 9/7/16.
 */
public class SearchInsertLocation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2};
        System.out.println(solution.searchInsert(array, 2));
    }

    public static class Solution {
        public int searchInsert(int[] nums, int target) {
            List<Integer> list = new ArrayList();
            for (int i : nums) {
                list.add(i);
            }

            int index = Collections.binarySearch(list, target);
            index = index < 0 ? (-1 * index) - 1 : index;

            return index;
        }
    }
}
