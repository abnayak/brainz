package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by abhijeet on 6/5/2016.
 * https://www.interviewbit.com/problems/n3-repeat-number/
 * You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
 * <p>
 * If so, return the integer. If not, return -1.
 * <p>
 * If there are multiple solutions, return any one.
 * <p>
 * Example :
 * <p>
 * Input : [1 2 3 1 1]
 * Output : 1
 * 1 occurs 3 times which is more than 5/3 times.
 * <p>
 * Algorithm.
 * Observation: There can be two numbers with more than N/3 repetition.
 * Example:
 * If N = 9
 * 11112222XX
 * We have 1 and 2 repeating for more than 9/3 times and we are left with only two numbers
 * <p>
 * 1. Maintain two slots with number and count
 * 2. If incoming number matching any of the slot, increment the counter.
 * 3. If the incoming number does not match any of the numbers in the slot
 * a. Decrement the count of each numbers in the slot, If it's zero then remove it from slot
 * b. If there is a empty slot, put the number in the slot and add the counter
 * 4. At the the end we may have a solution if we have numbers left in the slot. Scan the array and check the count to make
 * sure the numbers are occouring more than N/3 times.
 */

public class NByThreeRepeatNumbers {
    public static void main (String[] args) {
        Solution solution = new Solution();
        Integer[] array = new Integer[]{1000860, 1000860, 1000555, 1000249, 1000860, 1000480, 1000902, 1000740,
                1000343, 1000253, 1000535, 1000529, 1000540, 1000396, 1000716, 1000860, 1000860, 1000860, 1000991,
                1000860, 1000422, 1000600, 1000400, 1000305, 1000860, 1000860, 1000590, 1000509, 1000416, 1000997,
                1000860, 1000860, 1000309, 1000567, 1000860, 1000860, 1000860, 1000015, 1000468, 1000860, 1000860,
                1000105, 1000860, 1000860, 1000109, 1000066, 1000860, 1000912, 1000598, 1000586, 1000574, 1000801,
                1000325, 1000844, 1000633, 1000860, 1000800, 1000958, 1000860, 1000860, 1000649, 1000729, 1000287,
                1000949, 1000860, 1000860, 1000860, 1000847, 1000127, 1000860, 1000003, 1000666, 1000969, 1000387,
                1000028, 1000860, 1000193, 1000860, 1000812, 1000308, 1000771, 1000350, 1000860, 1000719, 1000048,
                1000860, 1000467, 1000194, 1000463, 1000246, 1000930, 1000669, 1000969, 1000860, 1000860, 1000165,
                1000280, 1000860, 1000920, 1000166, 1000860, 1000860, 1000577, 1000993, 1000860, 1000834, 1000768,
                1000058, 1000144, 1000860, 1000252, 1000860, 1000860, 1000860, 1000395, 1000212, 1000891, 1000314,
                1000928, 1000068, 1000230, 1000860, 1000648, 1000044, 1000107, 1000860, 1000188, 1000021, 1000279,
                1000915, 1000061, 1000965, 1000860, 1000860, 1000027, 1000860, 1000837, 1000148, 1000605, 1000268,
                1000307, 1000860, 1000584, 1000369, 1000433, 1000908, 1000860, 1000293, 1000860, 1000331, 1000860,
                1000860, 1000860, 1000860, 1000963, 1000607, 1000395, 1000860, 1000798, 1000501, 1000738, 1000860,
                1000645, 1000935, 1000860, 1000860, 1000559, 1000860, 1000860, 1000609, 1000171, 1000471, 1000860,
                1000957, 1000471, 1000630, 1000239, 1000591, 1000860, 1000860, 1000554, 1000860, 1000920, 1000915,
                1000065, 1000860, 1000739, 1000270, 1000769, 1000860};
        Integer[] array2 = new Integer[] {1,1,1,2,4,5,6};
        Integer[] array3 = new Integer[] { 1000441, 1000441, 1000994};
        Integer[] array4 = new Integer[] {1000860, 1000860, 1000555, 1000249, 1000860, 1000480, 1000902, 1000740,
                1000860, 1000343, 1000253, 1000535, 1000529, 1000540, 1000396, 1000716, 1000860, 1000860, 1000860,
                1000991, 1000860, 1000422, 1000600, 1000400, 1000305, 1000860, 1000860, 1000590, 1000509, 1000416,
                1000997, 1000860, 1000860, 1000309, 1000567, 1000860, 1000860, 1000860, 1000015, 1000468, 1000860,
                1000860, 1000105, 1000860, 1000860, 1000109, 1000066, 1000860, 1000912, 1000598, 1000586, 1000574,
                1000801, 1000325, 1000844, 1000633, 1000860, 1000800, 1000958, 1000860, 1000860, 1000649, 1000729,
                1000287, 1000949, 1000860, 1000860, 1000860, 1000847, 1000127, 1000860, 1000003, 1000666, 1000969,
                1000387, 1000028, 1000860, 1000193, 1000860, 1000812, 1000308, 1000771, 1000350, 1000860, 1000719,
                1000048, 1000860, 1000467, 1000194, 1000463, 1000246, 1000930, 1000669, 1000969, 1000860, 1000860,
                1000165, 1000280, 1000860, 1000920, 1000166, 1000860, 1000860, 1000577, 1000993, 1000860, 1000834,
                1000768, 1000058, 1000144, 1000860, 1000252, 1000860, 1000860, 1000860, 1000395, 1000212, 1000891,
                1000314, 1000928, 1000068, 1000230, 1000860, 1000648, 1000044, 1000107, 1000860, 1000188, 1000021,
                1000279, 1000915, 1000061, 1000965, 1000860, 1000860, 1000027, 1000860, 1000837, 1000148, 1000605,
                1000268, 1000307, 1000860, 1000584, 1000369, 1000433, 1000908, 1000860, 1000293, 1000860, 1000331,
                1000860, 1000860, 1000860, 1000860, 1000963, 1000607, 1000395, 1000860, 1000798, 1000501, 1000738,
                1000860, 1000645, 1000935, 1000860, 1000860, 1000559, 1000860, 1000860, 1000609, 1000171, 1000471,
                1000860, 1000957, 1000471, 1000630, 1000239, 1000591, 1000860, 1000860, 1000554, 1000860, 1000920,
                1000915, 1000065, 1000860, 1000739, 1000270, 1000769};
        System.out.println(solution.repeatedNumber(Arrays.asList(array4)));
    }

    public static class Solution {
        // DO NOT MODIFY THE LIST
        public int repeatedNumber (final List<Integer> a) {
            Map<Integer, Integer> slot = new HashMap<>();

            for (Integer i : a) {
                if (!slot.containsKey(i) && slot.size() < 2) {
                    slot.put(i, 1);
                    continue;
                }

                if (slot.containsKey(i)) {
                    slot.put(i, slot.get(i) + 1);
                } else {
                    Set<Integer> keys = new HashSet<>(slot.keySet());
                    for (Integer key : keys) {
                        if (slot.get(key) == 1) {
                            slot.remove(key);
                        } else {
                            slot.put(key, slot.get(key) - 1);
                        }
                    }
                }
            }


            // Do the actual counting of the keys
            for (Integer key : slot.keySet()) {
                int count = 0;
                for (int i : a) {
                    if (key == i) {
                        count++;
                    }
                }
                if (count > a.size() / 3) {
                    return key;
                }
            }
            return -1;
        }
    }

}
