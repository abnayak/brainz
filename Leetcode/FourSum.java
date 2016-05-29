import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by abhijeet on 5/23/2016.
 */
public class FourSum {
    public static void main (String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};

        List<List<Integer>> result = Solution.fourSum(nums, 0);

        for (List<Integer> partialResult : result) {
            for (Integer i : partialResult) {
                System.out.printf(i + " ");
            }
            System.out.printf("\n");
        }
    }

    public static class Solution {
        public static List<List<Integer>> fourSum (int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums.length < 4) {
                return result;
            }

            List<Integer[]> store = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    Integer[] temp = new Integer[]{i, j, nums[i] + nums[j]};
                    store.add(temp);
                }
            }

            // Sort the store according to the sum
            Collections.sort(store, new Comparator<Integer[]>() {
                @Override
                public int compare (final Integer[] o1, final Integer[] o2) {
                    return o1[2] - o2[2];
                }
            });

            // Find two elements in store such that
            // Sum of third element is target and all the indexes are unique
            int start = 0;
            int end = store.size() - 1;
            while (start < end) {
                if (store.get(start)[2] + store.get(end)[2] == target) {
                    System.out.println(store.get(start)[0] + " " + store.get(end)[0] + " " +
                    store.get(start)[0] + " " + store.get(end)[1] + " " +
                    store.get(start)[1] + " " + store.get(end)[0] + " " +
                    store.get(start)[1] + " " + store.get(end)[1]);

                    if (store.get(start)[0] != store.get(end)[0]
                            && store.get(start)[0] != store.get(end)[1]
                            && store.get(start)[1] != store.get(end)[0]
                            && store.get(start)[1] != store.get(end)[1]) {
                        List<Integer> tempResult = new ArrayList<>();
                        tempResult.add(nums[store.get(start)[0]]);
                        tempResult.add(nums[store.get(start)[1]]);
                        tempResult.add(nums[store.get(end)[0]]);
                        tempResult.add(nums[store.get(end)[1]]);
                        Collections.sort(tempResult);
                        result.add(tempResult);
                    }
                    start++;
                    end--;
                } else if (store.get(start)[2] + store.get(end)[2] > target) {
                    end--;
                } else {
                    start++;
                }
            }
            return result;
        }
    }
}
