package Hashing;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abhijeet on 11/23/16.
 */
public class FourSum {
    public class Solution {
        public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
            Collections.sort(a);
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            for (int i = 0; i < a.size() - 3; i++) {
                if (i > 0 && a.get(i) == a.get(i - 1)) continue;
                for (int j = i + 1; j < a.size() - 2; j++) {
                    if (j != i + 1 && a.get(j) == a.get(j - 1)) continue;
                    int left = j + 1;
                    int right = a.size() - 1;
                    while (left < right) {
                        int sum = a.get(i) + a.get(j) + a.get(left) + a.get(right);
                        if (sum == b) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(a.get(i));
                            list.add(a.get(j));
                            list.add(a.get(left));
                            list.add(a.get(right));
                            result.add(list);
                            left++;
                            right--;
                            while (right >= 0 && a.get(right + 1) == a.get(right)) right--;
                            while (left < a.size() && a.get(left - 1) == a.get(left)) left++;
                        } else if (sum < b) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }

            }
            return result;
        }
    }

}
