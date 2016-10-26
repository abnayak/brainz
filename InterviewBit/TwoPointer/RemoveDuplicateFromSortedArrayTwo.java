package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by abhijeet on 7/2/2016.
 * https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicateFromSortedArrayTwo {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
        System.out.println(removeDuplicates(arrayList));
        for (int i : arrayList) {
            System.out.printf("%d, ", i);
        }
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) return 0;

        int i = 0;

        while (i < a.size()) {
            if (i + 1 < a.size() && a.get(i).compareTo(a.get(i + 1)) == 0) {
                i++;
                int j = i + 1;

                while (j < a.size() && a.get(i).compareTo(a.get(j)) == 0) {
                    j++;
                }
                a.subList(i + 1, j).clear();
                i++;
            } else {
                i++;
            }
        }
        return a.size();
    }
}
