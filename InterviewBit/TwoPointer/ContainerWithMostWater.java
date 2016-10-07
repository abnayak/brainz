package TwoPointer;

import java.util.ArrayList;

/**
 * Created by abhijeet on 10/6/16.
 * https://www.interviewbit.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * 'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * <p>
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Your program should return an integer which corresponds to the maximum area of water that can be contained ( Yes, we know maximum area instead of maximum volume sounds weird. But this is 2D plane we are working with for simplicity ).
 * <p>
 * Note: You may not slant the container.
 * Example :
 * <p>
 * Input : [1, 5, 4, 3]
 * Output : 6
 * <p>
 * Explanation : 5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
 * So total area = 3 * 2 = 6
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] array = {1, 5, 4, 3};
        for (int i : array) {
            arrayList.add(i);
        }
        Solution solution = new Solution();
        System.out.println(solution.maxArea(arrayList));
    }

    public static class Solution {
        public int maxArea(ArrayList<Integer> a) {
            int i = 0;
            int j = a.size() - 1;
            int maxArea = 0;
            while (i < j) {
                int tempArea = (a.get(i) <= a.get(j) ? a.get(i) : a.get(j)) * (j - i);
                maxArea = tempArea > maxArea ? tempArea : maxArea;
                if (a.get(i) == a.get(j)) {
                    i++;
                    j--;
                } else if (a.get(i) < a.get(j)) {
                    i++;
                } else {
                    j--;
                }
            }
            return maxArea;
        }
    }
}
