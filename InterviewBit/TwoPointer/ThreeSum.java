package TwoPointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public static void main (String[] args) {
        Solution solution = new Solution();
        Integer[] array = new Integer[]{ 5, -2, -1, -10, 10 };

        System.out.println(solution.threeSumClosest(Arrays.asList(array), 5));
    }

    public static class Solution {
        public int threeSumClosest (List<Integer> a, int b) {
            Collections.sort(a);

            int distance = Integer.MAX_VALUE;
            int sum = 0;

            int begin = 0;
            int end = a.size() - 1;

            while (begin < end) {
                int partialSum = a.get(begin) + a.get(end);
                int i = (begin+end)/2;
                int p = begin+1;
                int q = end-1;
                while (p < q) {
                    int tempDistance = Math.abs(b - (partialSum + a.get(i)));
                    if (tempDistance < distance) {
                        distance = tempDistance;
                        sum = partialSum + a.get(i);
                    }

                    if (tempDistance > Math.abs(b-partialSum)) {
                        q = i-1;
                        i = (q+p)/2;
                    } else if(tempDistance < Math.abs(b-partialSum)) {
                        p = i+1;
                        i = (p+q)/2;
                    } else {
                        break;
                    }
                    System.out.printf("%d %d %d\n",p, q, i);
                }

                if (partialSum > b) {
                    end--;
                } else if (partialSum < b) {
                    begin++;
                } else if (partialSum == b) {
                    begin++;
                    end--;
                }

            }
            return sum;
        }

    }

}
