package Array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abhijeet on 6/2/2016.
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 */
public class MaxSumContinuousArray {

    public static void main (String[] args) {
        Solution solution = new Solution();
        Integer[] array = new Integer[]{-2,1,-3,4,-1,2,1,-5,4};

        System.out.printf("%d", solution.maxSubArray(Arrays.asList(array)));
    }

    public static class Solution {
        public int maxSubArray (final List<Integer> a) {
            int[] buffer = new int[a.size()];
            buffer[0] = a.get(0);

            for (int i = 1; i < a.size(); i++) {
                if(buffer[i-1] < buffer[i-1] + a.get(i)) {
                    buffer[i] = buffer[i-1] + a.get(i);
                } else if(buffer[i-1] + a.get(i) > a.get(i)){
                    buffer[i] = a.get(i) + buffer[i-1];
                } else {
                    buffer[i] = a.get(i);
                }
            }

            int max = buffer[0];
            for(int i : buffer) {
                if(i > max) {
                    max = i;
                }
            }
            return max;
        }
    }

}
