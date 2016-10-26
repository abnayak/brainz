package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by abhijeet on 7/13/2016.
 */
public class SortByColorV2 {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{ 0, 2, 0, 0, 0, 2, 2, 0, 0, 1, 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 0, 2, 2, 0, 2, 0, 1, 0, 2, 2, 1, 2, 0, 1, 1, 0, 0, 0, 2, 1, 1, 2, 2, 0, 0, 1, 1, 0, 2, 0, 0, 0, 0, 2, 0, 1, 0, 2, 1, 0, 0, 1, 2, 1, 2, 0, 1, 2, 2, 2, 1, 2, 1, 1, 0, 2, 2, 0, 2, 2, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 2, 2, 1, 0, 2, 2, 0, 0, 1, 0, 1, 2, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 2, 0, 1, 1, 1, 2, 0, 1, 2, 2, 2, 2, 1, 0, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 2, 2, 1, 1, 0, 2, 2, 0, 2, 2, 2, 0, 1, 0, 0, 1, 2, 2, 0, 1, 1, 1, 2, 0, 1, 1, 2, 2, 2, 1, 1, 0, 2, 2, 2, 0, 0, 2, 2, 2, 0, 0, 0, 0, 1, 2, 1, 1, 1, 0, 0, 2, 0, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 2, 2, 2, 0, 1, 2, 0, 2, 1, 0, 1, 1, 0, 1, 1, 0, 0, 2, 0, 0, 1, 0, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 0, 0, 0, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 1, 2, 1, 2, 0, 1, 2, 2, 2, 2, 0, 2, 2, 1, 0, 2, 0, 2, 1, 1, 1, 1, 0, 1, 0, 2, 2, 2, 2, 1, 0, 2, 0, 0, 0, 0, 0, 2, 1, 0, 0, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 0, 2, 2, 1, 1, 2, 2, 2, 0, 2, 0, 1, 1, 1, 0, 2, 2, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 2, 1, 0, 0, 1, 0, 1, 0, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 0, 1, 1, 2, 0, 2, 0, 2, 2, 1, 2, 2, 0, 1, 0, 2, 1, 2, 2, 2, 1, 0, 2, 2, 0, 1, 0, 2, 0, 0, 2, 2, 0, 0, 1, 2, 1, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 1, 1, 0, 2, 2, 0, 2, 2, 0, 2, 0, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 1, 1, 0, 0, 2, 0, 1, 0, 1, 0, 2, 1, 1, 0, 2, 0, 1, 0, 2, 0, 2, 2, 1, 0};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
        Solution solution = new Solution();
        solution.sortColors(arrayList);
        for (int i : arrayList) {
            System.out.printf("%d ", i);
        }
    }

    public static class Solution {
        public void sortColors(ArrayList<Integer> a) {
            if (a == null || a.size() <= 2) {
                return;
            }

            int firstIndex = 0;
            int thirdIndex = a.size() - 1;
            while (firstIndex + 1 < a.size()) {
                if (a.get(firstIndex) == 0) {
                    firstIndex++;
                } else {
                    break;
                }
            }
            while (thirdIndex - 1 > 0) {
                if (a.get(thirdIndex) == 2) {
                    thirdIndex--;
                } else {
                    break;
                }
            }

            int secondIndex = firstIndex + 1;
            while (secondIndex <= thirdIndex) {
                System.out.printf("%d %d %d\n", firstIndex, secondIndex, thirdIndex);
                if (a.get(secondIndex) == 0) {
                    Collections.swap(a, firstIndex, secondIndex);
                    firstIndex++;
                }
                if (a.get(secondIndex) == 2) {
                    Collections.swap(a, secondIndex, thirdIndex);
                    thirdIndex--;
                }
                secondIndex++;
            }
        }
    } // End of Solution class
}
