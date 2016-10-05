package TwoPointer;

import java.util.List;

/**
 * Created by abhijeet on 10/2/16.
 */
public class ArrayThreePointers {
    public static void main(String[] args) {

    }

    public class Solution {
        // DO NOT MODIFY THE LISTS
        public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
            int i = 0;
            int j = 0;
            int k = 0;
            int min = Integer.MAX_VALUE;

            int ai;
            int bj;
            int ck;
            int MINIMUM;
            int MAXIMUM;
            while (i < a.size() && j < b.size() && k < c.size()) {
                ai = a.get(i);
                bj = b.get(j);
                ck = c.get(k);

                MAXIMUM = Math.max(ai, Math.max(bj, ck));
                MINIMUM = Math.min(ai, Math.min(bj, ck));

                // Assign the new min
                min = MAXIMUM - MINIMUM < min ? MAXIMUM - MINIMUM : min;

                // If a[i] is less than other two
                if (ai == MINIMUM) i++;
                if (bj == MINIMUM) j++;
                if (ck == MINIMUM) k++;
            }
            return min;
        }
    }

}
