package Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by abhijeet on 11/17/16.
 */
public class DiffKII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {2,1,5};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : array) {
            list.add(i);
        }
        System.out.println(solution.diffPossible(list, 3));
    }

    public static class Solution {
        public int diffPossible(final List<Integer> a, int b) {
            HashSet<Integer> set = new HashSet<>();
            if (a == null || a.size() ==0) return 0;

            set.add(a.get(0));

            for (int i = 1; i < a.size(); i++) {
                if(set.contains(a.get(i) - b) || set.contains(a.get(i) +b)) return 1;
                set.add(a.get(i));
            }

            return 0;
        }
    }

}
