import java.util.*;

/**
 * Created by abhijeet on 6/12/2016.
 */
public class DiffK {

    public static void main (String[] args) {
        Solution solution = new Solution();
        Integer[] array = new Integer[] {1,3,5};
        System.out.printf("Is Solution present: " + solution.diffPossible(new ArrayList<>(Arrays.asList(array)), 4));
    }

    public static class Solution {
        public int diffPossible (ArrayList<Integer> a, int b) {
            if(a == null || a.size() < 2) {
                return 0;
            }

            int begin = 0;
            int end = 1;

            while(begin < end && end < a.size()) {
                int diff = a.get(end) - a.get(begin);
                if(diff > b) {
                    begin++;
                    // If both begin and end are equal, then move both of the indexes
                    if(end == begin)
                        end++;
                } else if (diff < b) {
                    end++;
                } else {
                    return 1;
                }
            }
            return 0;
        }
    }

}
