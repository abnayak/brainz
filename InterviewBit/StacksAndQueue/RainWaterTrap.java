package StacksAndQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhijeet on 10/11/16.
 * https://www.interviewbit.com/problems/rain-water-trapped/
 */
public class RainWaterTrap {
    public static void main(String[] args) {
        int[] walls = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        List<Integer> list = new ArrayList<>();
        for (int i : walls) {
            list.add(i);
        }
        System.out.println(trap(list));
    }

    // DO NOT MODIFY THE LIST
    public static int trap(final List<Integer> a) {
        int[] fromHead = new int[a.size()];
        int[] fromTail = new int[a.size()];

        int waterStored = 0;
        if (a.size() < 3) return waterStored;

        fromHead[0] = a.get(0);
        fromTail[a.size() - 1] = a.get(a.size() - 1);

        for (int i = 1; i < a.size(); i++) {
            if (fromHead[i - 1] < a.get(i))
                fromHead[i] = a.get(i);
            else
                fromHead[i] = fromHead[i - 1];
        }

        for (int i = a.size() - 2; i >= 0; i--) {
            if (fromTail[i + 1] < a.get(i))
                fromTail[i] = a.get(i);
            else
                fromTail[i] = fromTail[i + 1];
        }


        for (int i = 1; i < a.size() - 1; i++) {
            int sideWallHeight = fromHead[i - 1] < fromTail[i + 1] ? fromHead[i - 1] : fromTail[i + 1];
            if (sideWallHeight > a.get(i)) {
                waterStored += (sideWallHeight - a.get(i));
            }
        }
        return waterStored;
    }
}
