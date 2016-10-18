import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by abhijeet on 10/17/16.
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(array, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            if (nums == null || nums.length == 0 || k <= 0) return nums;

            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {
                // Remove the elements from the queue until a larger element is found
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) deque.removeLast();

                // Remove any element from the front which does not belong to current window
                while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) deque.removeFirst();

                // Add the current element to the window
                deque.addLast(i);

                if (i >= k - 1) {
                    //System.out.println(i + 1 - k);
                    result[i + 1 - k] = nums[deque.peekFirst()];
                }
            }
            return result;
        }
    }
}
