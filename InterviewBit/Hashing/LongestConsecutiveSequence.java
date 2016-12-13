package Hashing;

import java.util.*;

/**
 * Created by abhijeet on 12/7/16.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {100, 4, 200, 1, 3, 2};
        List<Integer> list = new ArrayList<>();
        for (int i : array) list.add(i);
        System.out.println(solution.longestConsecutive(list));
    }

    public static class Solution {
        public int longestConsecutive(final List<Integer> a) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < a.size(); i++) {
                set.add(a.get(i));
            }
            int MAX = 0;
            for (int i : a) {
                // If there is not element smaller than this, that implies this is the
                // start of the sequence.
                if (!set.contains(i - 1)) {
                    int count = 0;
                    while (set.contains(i + count)) count++;
                    MAX = Math.max(MAX, count);
                }
            }
            return MAX;
        }
    }
}
