/**
 * Created by abhijeet on 8/19/16.
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {

    }

    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1 == null) {
                return findMid(nums2);
            }
            if (nums2 == null) {
                return findMid(nums1);
            }

            int len = nums1.length + nums2.length;
            int mid = len / 2;

            int index1 = 0;
            int index2 = 0;
            while (index1 + index2 + 2 <= mid) {
                if (index1 + 1 < nums1.length && index2 + 1 < nums2.length) {
                    if (nums1[index1] < nums2[index2]) {
                        index1++;
                    } else {
                        index2++;
                    }
                }
                if (index1 == nums1.length + 1) {
                    index2++;
                } else {
                    index1++;
                }
            }
            if(len % 2 == 0) {
                int first = 10;
            }
            return 0;
        }

        private double findMid(int[] nums) {
            int len = nums.length;
            if (len % 2 == 0) {
                int mid = len / 2;
                return (nums[mid] + nums[mid + 1]) / 2;
            } else {
                return nums[len / 2];
            }
        }
    }
}
