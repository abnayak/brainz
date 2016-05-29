package Array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abhijeet on 3/9/16.
 */
public class FindDuplicate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = Arrays.asList(3,2,1,4);

        System.out.println(solution.repeatedNumber(list));

    }


    public static class Solution {
        // DO NOT MODIFY THE LIST
        public int repeatedNumber(final List<Integer> a) {
            Integer[] array = a.toArray(new Integer[a.size()]);

            for(int i = 0; i< array.length; i++) {
                if(array[Math.abs(array[i]) -1] < 0  ) {
                    return Math.abs(array[i]);
                } else {
                    array[Math.abs(array[i]) - 1]  = -1 * array[Math.abs(array[i]) - 1];
                }
            }
            return 0;
        }
    }

}
