import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhijeet on 9/20/16.
 * https://leetcode.com/problems/subsets/
 */
public class Subset {
    public static void main(String[] args) {

    }

    public class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            findSubsets(nums, 0, new LinkedList<>());
            return result;
        }

        private void findSubsets(int[] nums, int index, LinkedList<Integer> list) {
            if(index >= nums.length) {
                List<Integer> temp = new ArrayList<>();
                for(Integer i : list) {
                    temp.add(i);
                }
                result.add(temp);
                return;
            }

            list.addLast(nums[index]);
            findSubsets(nums, index+1, list);
            list.removeLast();
            findSubsets(nums, index+1, list);
        }
    }
}
