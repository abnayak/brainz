/**
 * Created by abhijeet on 9/20/16.
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(6));
    }

    public static class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1) return x;

            int start = 1;
            int end = x;
            int mid = (start + end) / 2;

            while (start <= end) {
                if (mid == x / mid) {
                    return mid;
                } else if (mid < x / mid) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = (start + end) / 2;
            }

            return end;
        }
    }
}


 // 1 2 3 4 5 6
//  0 1 2 3 4 5