package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by abhijeet on 3/14/16.
 * https://www.interviewbit.com/problems/rearrange-array/
 */

public class RearrangeArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1,0));
        solution.arrange(array);

        for (Integer i : array) {
            System.out.println(i);
        }
    }
    public static class Solution {
        public void arrange(ArrayList<Integer> a) {
            int n = a.size();
            for(int i = 0; i< a.size(); i++) {
                a.set(i, a.get(i) +  (a.get(a.get(i))%n)*n );
            }

            for(int i = 0; i< a.size(); i++) {
                a.set(i, a.get(i)/n);
            }
        }
    }


}
