package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 9/29/16.
 */
public class SingleNumber {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int[] array = {2,2,2,3,3,3,4,4,4,6,6,6,10};
        for(int i : array) {
            list.add(i);
        }
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(list));
    }
    public static class Solution {
        // DO NOT MODIFY THE LIST
        public int singleNumber(final List<Integer> a) {
            int result = a.get(0);
            for(int i = 1; i < a.size(); i++) {
                result = a.get(i);
            }
            return result;
        }
    }
}
