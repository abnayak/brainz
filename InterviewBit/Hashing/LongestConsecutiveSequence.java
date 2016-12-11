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
        for(int i : array) list.add(i);
        System.out.println(solution.longestConsecutive(list));
    }

    public static class Solution {
        public int longestConsecutive(final List<Integer> a) {
            Hashtable<Integer, List<Integer>> map = new Hashtable<>();
            for (int i = 0; i < a.size(); i++) {
                map.put(a.get(i), new ArrayList<>());
            }
            boolean run = true;
            int index = 0;
            while(run && index < map.size()) {
                run = false;
                Set<Integer> keySet = new HashSet<>(map.keySet());
                for (Integer i : keySet) {
                    if(map.containsKey(i+1)) {
                        run = true;
                        List<Integer> list = map.get(i);
                        list.add(i+1);
                        list.addAll(map.get(i+1));
                        map.remove(i+1);
                    }
                }
            }
            Set<Integer> keySet = map.keySet();
            int max = 0;
            for(Integer i : keySet) {
                max = Math.max(max, map.get(i).size());
            }
            return max+1;
        }
    }
}
