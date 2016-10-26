package TwoPointer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abhijeet on 10/5/16.
 * https://www.interviewbit.com/problems/sort-by-color/
 */
public class SortByColor {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 0, 1, 2};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }
        Solution solution = new Solution();
        solution.sortColors(arrayList);

        for (int i : arrayList) {
            System.out.println(i);
        }
    }

    public static class Solution {
        public void sortColors(ArrayList<Integer> a) {
            int begin = -1;
            int end = a.size();
            int mid = 0;
            while (mid < end) {
                if (a.get(mid) == 0) {
                    Collections.swap(a, ++begin, mid);
                    mid++;
                } else if (a.get(mid) == 2) {
                    Collections.swap(a, mid, --end);
                } else {
                    mid++;
                }
            }
        }
    }

}