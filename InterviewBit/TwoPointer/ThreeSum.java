package TwoPointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] array = new Integer[]{-4, -8, -10, -9, -1, 1, -2, 0, -8, -2};

        System.out.println(solution.threeSumClosest(Arrays.asList(array), 0));
    }

    public static class Solution {
        public int threeSumClosest(List<Integer> a, int b) {
            Collections.sort(a);

            int low = 0;
            int high = a.size() - 1;
            int sum = a.get(0) + a.get(1) + a.get(3);
            while (low < high - 1) {
                for (int i = low + 1; i < high; i++) {
                    int temp = a.get(low) + a.get(high) + a.get(i);
                    if (temp == b) return b;
                    if (Math.abs(temp - b) < Math.abs(sum - b)) {
                        sum = temp;
                    }
                }
                if (a.get(low) + a.get(high) < b) {
                    low++;
                } else {
                    high--;
                }
            }
            return sum;
        }
    }
}
