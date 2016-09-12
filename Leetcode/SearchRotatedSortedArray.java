/**
 * Created by abhijeet on 9/11/16.
 */
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] mid = {3,4,5,6,1,2};

        Solution solution = new Solution();
        System.out.println(solution.search(mid, 4));
    }

    public static class Solution {
        public int search(int[] nums, int target) {
            int pivotPoint = searchMid(nums);
            System.out.println(pivotPoint);

            // search on left tree
            int location = binarySearch(nums, target, 0, pivotPoint);
            if (location != -1) {
                return location;
            } else {
                return binarySearch(nums, target, pivotPoint + 1, nums.length - 1);
            }
        }

        private int searchMid(int[] nums) {
            int head = 0;
            int tail = nums.length - 1;
            int mid;

            while (nums[head] > nums[tail]) {
                mid = (head + tail) / 2;
                if (nums[mid] > nums[tail]) {
                    head = mid + 1;
                }else {
                    tail = mid;
                }
            }
            return head-1;
        }

        private int binarySearch(int[] nums, int target, int begin, int end) {
            if (begin < 0) return -1;
            if (end > nums.length - 1) return -1;
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
