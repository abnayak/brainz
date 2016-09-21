/**
 * Created by abhijeet on 9/20/16.
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

    public static class Solution {
        public int mySqrt(int x) {
            float low = 1;
            float high = x;
            while (true) {
                float mid = (low + high) / 2;
                float temp = x / mid;

//                if (mid - temp < 0) {
//                    low = mid;
//                } else if (mid - temp > 0.001) {
//                    high = mid;
//                } else {
//                    return (int) mid;
//                }
                if((int) mid == (int) temp) {
                    return (int)mid;
                } else if((int) temp < (int) mid) {
                    low = mid;
                } else {
                    high = mid;
                }
            }
        }
    }
}
